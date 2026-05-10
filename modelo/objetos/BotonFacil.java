package modelo.objetos;

import stdlib.StdDraw;

public class BotonFacil extends Boton {

    public BotonFacil(String n, double x, double y, double ancho, double alto) {
        super(n, x, y, ancho, alto);
    }

    @Override
    public void pintar() {
        StdDraw.setPenColor(StdDraw.GREEN);
        StdDraw.filledRectangle(x, y, ancho/2, alto/2);

        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(x,y, name);
    }

    @Override
    public void mouse() {
        // Código para detectar el clic del mouse en el botón
    }

    @Override
    public void interaccion(Object o) {
        // Código para seleccionar la dificultad fácil cuando se haga clic en el botón
    }
}
