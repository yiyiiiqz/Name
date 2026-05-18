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

public class Tiles extends Figure{
    // 24.5*4 = 98
    // 1, 0.5
    // 24.25/2= 12.125
    private static final double[] POSITION_X={1+12.125, 1+24.25+0.5+12.125, 1+24.25+0.5+24.25+0.5+12.125,1+24.25+0.5+24.25+0.5+24.25+0.5+12.125};
    private static final int[] KEYS={KeyEvent.VK_D, KeyEvent.VK_F, KeyEvent.VK_J, KeyEvent.VK_K};
    private boolean touched;
    private static int random;

    public Tiles(){
        super(POSITION_X[genRandom()],80,0.01,4);
        touched= false;
    }

    private static int genRandom() {
        random= new Random().nextInt(4);
        return random;
    }

    public void touched(HealthPoints h){
        if(StdDraw.isKeyPressed(KEYS[random])){touched=true; System.out.println("a");}
        else h.perderVida();
    }

    public void pintar(Interfaz i, HealthPoints h){
        StdDraw.setPenColor(StdDraw.WHITE);
        /*StdDraw.filledSquare(x,y,50);
        //StdDraw.filledCircle(x,y,4);
        actualizarY();*/
        
        for(double j=y;j>0 && !touched;j--){
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.filledSquare(x,j,halfHeight);
            StdDraw.setPenColor(StdDraw.PINK);
            StdDraw.filledSquare(x,j+7,halfHeight);
            if(j-halfHeight<=15 && j+halfHeight>=15) touched(h);
            StdDraw.show();
            StdDraw.pause(10);
        }
        addPoints(i, h);
    }

    public void addPoints(Interfaz i, HealthPoints h){
        if(touched) i.addPoints();
    }

    public double getY(){
        return y;
    }

    public double getHalfHeight(){
        return halfHeight;
    }
}
