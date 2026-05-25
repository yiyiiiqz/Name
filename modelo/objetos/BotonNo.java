package modelo.objetos;

import modelo.Interfaz;
import stdlib.StdDraw;

public class BotonNo extends Boton {

    public BotonNo(String n, double x, double y, double halfWidth, double halfHeight) {
        super(n, x, y, halfWidth, halfHeight);
    }

    @Override
    public void pintar() {
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.filledRectangle(x, y, halfWidth, halfHeight);

        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(x,y, name);
    }

    @Override
    public void mouse() {
        if(overFigure()){
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.filledRectangle(x,y,halfWidth,halfHeight);
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.text(x, y, name);
        }
        else{
            pintar();
        }
    }

    @Override
    public void interaccion(Interfaz i) {
        if(StdDraw.mousePressed() && overFigure()){
            while(StdDraw.mousePressed()) StdDraw.pause(20);
            i.siguienteInterfaz(this); // game over
        }
    }
}
