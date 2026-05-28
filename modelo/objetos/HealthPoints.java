package modelo.objetos;

import java.util.Stack;

import stdlib.*;

public class HealthPoints {
    protected int vidasMax = 5;
    protected Stack<Integer> vidas;
    protected int contadorVidasUsadas; // para score

    public HealthPoints(int vidasMax) {
        this.vidasMax = vidasMax;
        this.contadorVidasUsadas = 0;

        vidas = new Stack<>();
        for (int i = 0; i < vidasMax; i++) vidas.push(1);
    }

    public void perderVida() {
        if (!vidas.isEmpty()) {
            vidas.pop();
            contadorVidasUsadas++;
        }
    }

    public void ganarVida() {
        if (vidas.size() < vidasMax) {
            vidas.push(1);
        }
    }

    public int getVidasActuales() {
        return vidas.size();
    }

    public int getContadorVidasUsadas() {
        return contadorVidasUsadas;
    }

    public void dibujar() {

        double xInicio = 70; // izquierda
        double y = 95; // arriba
        double separacion = 6;

        for (int i = 0; i < vidasMax; i++) {
            StdDraw.setPenColor(StdDraw.RED);
            if (i < vidas.size())
                StdDraw.picture(xInicio + i * separacion, y, "Vidas.png",5,5);
            else StdDraw.picture(xInicio + i * separacion, y, "VidasPerdidas.png",5,5);
        }
    }
}
