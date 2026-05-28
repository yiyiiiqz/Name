package modelo.objetos;
import stdlib.StdDraw;

public class Line extends Figure {

    private String lineImage="Line.png";

    public Line(){
        super(50,15,30,15);
    }

    public void pintar(){
        StdDraw.setPenColor(StdDraw.GRAY);
        //StdDraw.setPenRadius(0.02);
        StdDraw.line(0,y,100,y);
        //StdDraw.picture(x,y,lineImage,halfWidth*2,halfHeight*2);
        //StdDraw.setPenRadius();
    }

    public boolean tocando(Tiles t){
        if(t.getY()-t.getHalfHeight()<=y) return true;
        else return false;
    }
}
