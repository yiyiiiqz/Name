/*
- En el constructor debes de usar el super y el this antes de declarar cualquier otra variable
- No se puede usar rand.nextInt(n) en el constructor pero sí crear uno nuevo: new Random().nextInt(n);
*/

package modelo.objetos;

import java.util.Random;

import stdlib.StdDraw;
import stdlib.StdRandom;
import modelo.Interfaz;

public class Tiles extends Figure{
    // 24.5*4 = 98
    // 1, 0.5
    // 24.25/2= 12.125
    private static final double[] POSITION_X={1+12.125, 1+24.25+0.5+12.125, 1+24.25+0.5+24.25+0.5+12.125,1+24.25+0.5+24.25+0.5+24.25+0.5+12.125};
    private static final char[] KEYS={'d','f','j','k'};
    private boolean touched;
    private static int random;

    public Tiles(){
        
        super(POSITION_X[gen_random()],80,0.01,4);
        touched= false;
    }

    private static int gen_random() {
        random= new Random().nextInt(4);
        return random;
    }

    public void touched(HealthPoints h){
        if(StdDraw.mousePressed() && overFigure()) touched=true;
        else h.perderVida();
    }

    public void actualizarY(){
        y+=0.1;
    }

    public void pintar(Interfaz i, HealthPoints h){
        StdDraw.setPenColor(StdDraw.WHITE);
        /*StdDraw.filledSquare(x,y,50);
        //StdDraw.filledCircle(x,y,4);
        actualizarY();*/
        
        for(double j=y;j>0 && !touched;j--){
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.filledSquare(x,j,4);
            StdDraw.setPenColor(StdDraw.PINK);
            StdDraw.filledSquare(x,j+7,4);
            if(j==5) touched(h);
            StdDraw.show();
            StdDraw.pause(10);
        }
        addPoints(i);
    }

    public void addPoints(Interfaz i){

        if(touched) i.addPoints();
    }

    public double getY(){
        return y;
    }

    public double getHalfHeight(){
        return halfHeight;
    }
}
