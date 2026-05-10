package modelo.objetos;

public abstract class Boton {
    protected String name;
    protected double x;
    protected double y;
    protected double ancho;
    protected double alto;

    public Boton(String n, double x, double y, double ancho, double alto) {
        name = n;
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
    }

    public abstract void pintar();

    public abstract void mouse();

    public abstract void interaccion();
}
