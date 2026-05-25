/*
- En el constructor debes de usar el super antes de declarar cualquier otra variable
- No se puede usar rand.nextInt(n) en el constructor pero sí crear uno nuevo: new Random().nextInt(n);
- También se puede usar una función auxiliar
- Random().nextInt(4); excluye el 4
*/

package modelo.objetos;

import java.util.Random;
import java.awt.event.KeyEvent;

import stdlib.StdDraw;

public class Tiles extends Figure {
    // 24.5*4 = 98
    // 1, 0.5
    // 24.25/2= 12.125
    private static final double[] POSITION_X = { 1 + 12.125, 1 + 24.25 + 0.5 + 12.125,
            1 + 24.25 + 0.5 + 24.25 + 0.5 + 12.125, 1 + 24.25 + 0.5 + 24.25 + 0.5 + 24.25 + 0.5 + 12.125 };
    private static final int[] KEYS = { KeyEvent.VK_D, KeyEvent.VK_F, KeyEvent.VK_J, KeyEvent.VK_K };
    private boolean touched;
    private int columnaRandom;
    private boolean teclaPulsadaAntes; //Evitar mantener pulsado
    private boolean penalizadoAntes;

    public Tiles() {
        super(0, 80, 0.01, 4);
        columnaRandom = new Random().nextInt(4);
        x = POSITION_X[columnaRandom];
        touched = false;
    }

    public void touched(HealthPoints hp) {
        boolean teclaActual = StdDraw.isKeyPressed(KEYS[columnaRandom]);
        if (overLine()) {
            if (teclaActual && !teclaPulsadaAntes) touched = true; //Si la tecla estaba pulsada en el frame anterior, ya no cuenta como touched
        }
        teclaPulsadaAntes = teclaActual;
    }

    public boolean isTouched(){
        return touched;
    }

    public boolean wrongKeyPressed(){
        boolean isKeyPressed= StdDraw.isKeyPressed(KEYS[0])||StdDraw.isKeyPressed(KEYS[1])||StdDraw.isKeyPressed(KEYS[2])||StdDraw.isKeyPressed(KEYS[3]);
        boolean correctKeyPressed= StdDraw.isKeyPressed(columnaRandom);
        return isKeyPressed && !correctKeyPressed;
    }

    public boolean afterLine(){
        return y+halfHeight<15;
    }
    
    public boolean overLine(){
        return y - halfHeight <= 15 && y + halfHeight >= 15;
    }

    public void pintar() {
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.filledSquare(x, y, halfHeight);

        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.square(x, y, halfHeight);
    }

    public void actualizar(double velocidad) {
        y -= velocidad;
    }

    public double getY() {
        return y;
    }

    public double getHalfHeight() {
        return halfHeight;
    }

    public int getKey(){
        return KEYS[columnaRandom];
    }

    public void setPenalizadoAntes(boolean b){
        penalizadoAntes= b;
    }

    public boolean getPenalizadoAntes(){
        return penalizadoAntes;
    }
}
