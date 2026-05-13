package modelo.objetos;

import stdlib.StdDraw;
import modelo.Interfaz;

public abstract class Barra {
    protected int maxAtributo;
    protected String atributo;
    protected double x;
    protected double y;
    protected double halfWidth;
    protected double halfHeight;
    // private IList<Integer> contador;

    public Barra(int maxAtributo, String atributo, double x, double y, double halfWidth, double halfHeight){
        this.maxAtributo=maxAtributo;
        this.atributo=atributo;
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

    public abstract void moverContador(Interfaz i);

    public abstract void pintar(Interfaz i);
}
