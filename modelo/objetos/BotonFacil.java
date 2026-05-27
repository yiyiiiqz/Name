package modelo.objetos;

import modelo.Interfaz;
import stdlib.StdDraw;

public class BotonFacil extends Boton {

    private String imagenFacil = "Easy.png";
    private String imagenFacil2 = "EasyHover.png";

    public BotonFacil(String n, double x, double y, double halfWidth, double halfHeight) {
        super(n, x, y, halfWidth, halfHeight);
    }

    @Override
    public void pintar() {
        StdDraw.picture(x, y, imagenFacil, halfWidth * 2, halfHeight * 2);
    }

    @Override
    public void mouse() {
        if (overFigure()) {
            StdDraw.picture(x, y, imagenFacil2, halfWidth * 2, halfHeight * 2);
        } else {
            pintar();
        }
    }

    @Override
    public void interaccion(Interfaz i) {
        if (StdDraw.mousePressed() && overFigure()) {
            while (StdDraw.mousePressed())
                StdDraw.pause(20);
            i.siguienteInterfaz(this);
        }
    }
}
