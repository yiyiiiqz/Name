package modelo.objetos;

import stdlib.StdDraw;

public class Figure {
    protected double x;
    protected double y;
    protected double halfWidth;
    protected double halfHeight;

    public Figure(double x, double y, double halfWidth, double halfHeight){
        this.x=x;
        this.y=y;
        this.halfWidth=halfWidth;
        this.halfHeight=halfHeight;
    }

    public void roundedCornersRectangle(double x, double y, double halfWidth, double halfHeight){
        StdDraw.filledRectangle(x, y, halfWidth, halfHeight);
        StdDraw.filledCircle(x-halfWidth,y,halfHeight);
        StdDraw.filledCircle(x+halfWidth,y,halfHeight);
    }

    public boolean overFigure(){
        double mx= StdDraw.mouseX();
        double my= StdDraw.mouseY();
        return mx>=x-halfWidth && mx<=x+halfWidth && my>=y-halfHeight && my<=y+halfHeight;
    }
}
