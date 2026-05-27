package modelo.objetos;
import stdlib.StdDraw;

public class Line extends Figure {
    /*private double x0=0;
    private double x1=100;
    private double y0=15;
    private double y1=y0;*/

    private String lineImage="Line.png";

    public Line(){
        super(50,15,30,15);
    }

    public void pintar(){
        //StdDraw.setPenColor(StdDraw.WHITE);
        //StdDraw.line(x0,y0,x1,y1);
        StdDraw.picture(x,y,lineImage,halfWidth*2,halfHeight*2);
    }

    public boolean tocando(Tiles t){
        if(t.getY()-t.getHalfHeight()<=y) return true;
        else return false;
    }
}
