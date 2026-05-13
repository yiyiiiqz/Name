package modelo.objetos;

import stdlib.StdDraw;
import modelo.Interfaz;

public abstract class Barra {
    protected int maxAtributo;
    protected int valorAtributo;
    protected String atributo;
    protected double x;
    protected double y;
    protected double halfWidth;
    protected double halfHeight;
    // private IList<Integer> contador;

    public Barra(int maxAtributo, String atributo){
        this.maxAtributo=maxAtributo;
        valorAtributo=0;
        this.atributo=atributo;
    }

    public void roundedCornersRectangle(double x, double y, double halfWidth, double halfHeight){
        StdDraw.filledRectangle(x, y, halfWidth, halfHeight);
        StdDraw.filledCircle(y,x-halfWidth,halfHeight);
        StdDraw.filledCircle(y,x-halfWidth,halfHeight);
    }

    public abstract void moverContador(Interfaz i);

    public abstract void pintar();
}
