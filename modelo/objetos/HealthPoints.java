package modelo.objetos;

import stdlib.*;

public class HealthPoints {
    protected int vidasMax = 5;
    protected int vidasActuales;
    protected int contadorVidasUsadas; // para score

    public HealthPoints(int vidasMax) {
        this.vidasMax = vidasMax;
        this.vidasActuales = vidasMax;
        this.contadorVidasUsadas = 0;
    }

    public void perderVida() {
        if (vidasActuales > 0) {
            vidasActuales--;
            contadorVidasUsadas++;
        }
    }

    public void ganarVida() {
        if (vidasActuales < vidasMax) {
            vidasActuales++;
        }
    }

    public int getVidasActuales() {
        return vidasActuales;
    }

    public int getContadorVidasUsadas() {
        return contadorVidasUsadas;
    }

    public void dibujar() {

        double xInicio = 80; // izquierda
        double y = 95; // arriba
        double radio = 1.5; // tamaño del círculo
        double separacion = 4;

        for (int i = 0; i < vidasMax; i++) {
            StdDraw.setPenColor(StdDraw.RED);
            if (i < vidasActuales) StdDraw.filledCircle(xInicio + i * separacion, y, radio);
            else StdDraw.circle(xInicio + i * separacion, y, radio);
        }
    }
}
