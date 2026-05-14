package modelo.objetos;
import stdlib.StdDraw;

public class Line {
    private double x0=0;
    private double x1=100;
    private double y0=5;
    private double y1=y0;

    public void pintar(){
        //StdDraw.setPenRadius(0.5);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.line(x0,y0,x1,y1);
    }

    public boolean tocando(Tiles t){
        if(t.getY()-t.getHalfHeight()<=y0) return true;
        else return false;
    }
}
