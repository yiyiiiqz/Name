package modelo.objetos;

import stdlib.StdDraw;

public class BotonDificil extends Boton {

    public BotonDificil(String n, double x, double y, double ancho, double alto) {
        super(n, x, y, ancho, alto);
    }

    @Override
    public void pintar() {
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.rectangle(x, y, ancho, alto);

        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(ancho/2, alto/2, name);
    }

    @Override
    public void mouse() {
        // Código para detectar el clic del mouse en el botón
    }

    @Override
    public void interaccion() {
        // Código para seleccionar la dificultad difícil cuando se haga clic en el botón
    }
}
