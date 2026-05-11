package modelo.objetos;

import modelo.Interfaz;
import stdlib.StdDraw;

public class BotonDificil extends Boton {

    public BotonDificil(String n, double x, double y, double ancho, double alto) {
        super(n, x, y, ancho, alto);
    }

    @Override
    public void pintar() {
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.filledRectangle(x, y, ancho/2, alto/2);

        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(x, y, name);
    }

    @Override
    public void mouse() {
        if(overButton()){
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.filledRectangle(x,y,ancho/2,alto/2);
            StdDraw.setPenColor(StdDraw.PINK);
            StdDraw.text(x, y, name);
            StdDraw.show();
        }
        else{
            pintar();
        }
    }

    @Override
    public void interaccion(Object o) {
        Interfaz i= (Interfaz) o;
        if(StdDraw.mousePressed() && overButton()){
            //Añadir animación+ sonido
            i.siguienteInterfaz(2);
        }
    }
}
