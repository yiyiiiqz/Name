package modelo.objetos;

public abstract class Boton {
    protected String name;
    protected double x;
    protected double y;

    public Boton(String n, double x, double y){
        name= n;
        this.x=x;
        this.y=y;
    }

    public abstract void pintar();

    public abstract void mouse();

    public abstract void interaccion();
}
