package modelo.objetos;

import modelo.Interfaz;

public abstract class Barra extends Figure{
    protected int maxAtributo;
    protected String atributo;
    // private IList<Integer> contador;

    public Barra(int maxAtributo, String atributo, double x, double y, double halfWidth, double halfHeight){
        super(x, y, halfWidth, halfHeight);
        this.maxAtributo=maxAtributo;
        this.atributo=atributo;
    }

    public abstract void moverContador(Interfaz i);

    public abstract void pintar(Interfaz i);
}
