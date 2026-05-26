package modelo.objetos;

import modelo.Interfaz;
import stdlib.StdDraw;

public class BotonFacil extends Boton {

    private String imagenFacil = "beginner.png";
    private String imagenFacil2 = "beginner2.png";

    public BotonFacil(String n, double x, double y, double halfWidth, double halfHeight) {
        super(n, x, y, halfWidth, halfHeight);
    }

    @Override
    public void pintar() {
        StdDraw.picture(x, y, imagenFacil, halfWidth * 2, halfHeight * 2);
        /*
         * StdDraw.setPenColor(StdDraw.GREEN);
         * StdDraw.filledRectangle(x, y, halfWidth, halfHeight);
         * 
         * StdDraw.setPenColor(StdDraw.BLACK);
         * StdDraw.text(x,y, name);
         */
    }

    @Override
    public void mouse() {
        if (overFigure()) {
            StdDraw.picture(x, y, imagenFacil2, halfWidth * 2, halfHeight * 2);
            /*StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.filledRectangle(x, y, halfWidth, halfHeight);
            StdDraw.setPenColor(StdDraw.PINK);
            StdDraw.text(x, y, name);*/
        } else {
            pintar();
        }
    }

    @Override
    public void interaccion(Interfaz i) {
        if (StdDraw.mousePressed() && overFigure()) {
            while (StdDraw.mousePressed())
                StdDraw.pause(20);
            // Añadir animación+ sonido
            i.siguienteInterfaz(this);
        }
    }
}
