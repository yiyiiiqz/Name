package modelo.objetos;

import stdlib.StdDraw;

public class Figura {

    public Figura(){}

    public void roundedCornersRectangle(double x, double y, double halfWidth, double halfHeight){
        StdDraw.filledRectangle(x, y, halfWidth, halfHeight);
        StdDraw.filledCircle(x-halfWidth,y,halfHeight);
        StdDraw.filledCircle(x+halfWidth,y,halfHeight);
    }
}
