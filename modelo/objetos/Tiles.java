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
import modelo.Interfaz;

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

    public Tiles() {
        super(0, 80, 0.01, 4);
        columnaRandom = new Random().nextInt(4);
        x = POSITION_X[columnaRandom];
        touched = false;
    }

    public void touched(HealthPoints hp) {
        boolean teclaActual = StdDraw.isKeyPressed(KEYS[columnaRandom]);
        boolean teclaActualGeneral = StdDraw.isKeyPressed(KEYS[0])||StdDraw.isKeyPressed(KEYS[1])||StdDraw.isKeyPressed(KEYS[2])||StdDraw.isKeyPressed(KEYS[3]);
        boolean overTheLine = y - halfHeight <= 15 && y + halfHeight >= 15;
        if (overTheLine) {
            if (teclaActual && !teclaPulsadaAntes) touched = true; //Si la tecla estaba pulsada en el frame anterior, ya no cuenta como touched
        }
        else{
            if(teclaActualGeneral) hp.perderVida();
        }
        /*else if(teclaActual && !teclaPulsadaAntes) hp.perderVida();*/
        teclaPulsadaAntes = teclaActual;
    }

    public boolean isTouched(){
        return touched;
    }

    public void pintar() {
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.filledSquare(x, y, halfHeight);
    }

    public void actualizar(double velocidad) {
        y -= velocidad;
    }

    /*
     * public void pintar(Interfaz i, HealthPoints h){
     * StdDraw.setPenColor(StdDraw.WHITE);
     * /*StdDraw.filledSquare(x,y,50);
     * //StdDraw.filledCircle(x,y,4);
     * actualizarY();
     * 
     * for(double j=y;j>0 && !touched;j--){
     * StdDraw.setPenColor(StdDraw.WHITE);
     * StdDraw.filledSquare(x,j,halfHeight);
     * StdDraw.setPenColor(StdDraw.PINK);
     * StdDraw.filledSquare(x,j+7,halfHeight);
     * if(j-halfHeight<=15 && j+halfHeight>=15) touched(h);
     * StdDraw.show();
     * StdDraw.pause(10);
     * }
     * addPoints(i, h);
     * }
     */


    public double getY() {
        return y;
    }

    public double getHalfHeight() {
        return halfHeight;
    }
}
