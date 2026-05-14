package modelo.objetos;

import modelo.Interfaz;

public abstract class Boton extends Figure{
    protected String name;

    public Boton(String n, double x, double y, double halfWidth, double halfHeight) {
        super(x,y,halfWidth,halfHeight);
        name=n;
    }

    public abstract void pintar();

    public abstract void mouse();

    public abstract void interaccion(Interfaz i);
}
