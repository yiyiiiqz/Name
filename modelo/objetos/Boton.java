package modelo.objetos;
import modelo.base.*;

public abstract class Boton {
    private String name;
    private Punto position;

    public Boton(String n, double x, double y){
        name= n;
        position= new Punto(x,y);
    }

    public abstract void pintar();

    public abstract void mouse();

    public abstract void interaccion();
}
