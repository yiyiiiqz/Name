package modelo.objetos;

import modelo.Interfaz;
import stdlib.StdDraw;

public class BotonDificil extends Boton {

    private String imagenDificil = "Hard.png";
    private String imagenDificil2 = "HardHover.png";

    public BotonDificil(String n, double x, double y, double ancho, double alto) {
        super(n, x, y, ancho, alto);
    }

    @Override
    public void pintar() {
        StdDraw.picture(x, y, imagenDificil, halfWidth * 2, halfHeight * 2);
    }

    @Override
    public void mouse() {
        if(overFigure()){
            StdDraw.picture(x, y, imagenDificil2, halfWidth * 2, halfHeight * 2);
        }
        else{
            pintar();
        }
    }

    @Override
    public void interaccion(Interfaz i) {
        if(StdDraw.mousePressed() && overFigure()){
            while(StdDraw.mousePressed()) StdDraw.pause(20);
            i.siguienteInterfaz(this);
        }
    }
}
