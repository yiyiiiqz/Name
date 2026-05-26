package modelo.objetos;

import modelo.Interfaz;
import stdlib.StdDraw;

public class BotonDificil extends Boton {

    private String imagenDificil = "hardcore.png";
    private String imagenDificil2 = "hardcore2.png";

    public BotonDificil(String n, double x, double y, double ancho, double alto) {
        super(n, x, y, ancho, alto);
    }

    @Override
    public void pintar() {
        StdDraw.picture(x, y, imagenDificil, halfWidth * 2, halfHeight * 2);
        /*StdDraw.setPenColor(StdDraw.RED);
        StdDraw.filledRectangle(x, y, halfWidth, halfHeight);

        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(x, y, name);*/
    }

    @Override
    public void mouse() {
        if(overFigure()){
            StdDraw.picture(x, y, imagenDificil2, halfWidth * 2, halfHeight * 2);
            /*StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.filledRectangle(x,y,halfWidth,halfHeight);
            StdDraw.setPenColor(StdDraw.PINK);
            StdDraw.text(x, y, name);*/
        }
        else{
            pintar();
        }
    }

    @Override
    public void interaccion(Interfaz i) {
        if(StdDraw.mousePressed() && overFigure()){
            while(StdDraw.mousePressed()) StdDraw.pause(20);
            //Añadir animación+ sonido
            i.siguienteInterfaz(this);
        }
    }
}
