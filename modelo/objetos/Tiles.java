package modelo.objetos;

import java.util.Random;

import stdlib.StdRandom;

public class Tiles extends Figure{
    // 24.5*4 = 98
    // 1, 0.5
    // 24.25/2= 12.125
    private static final double[] POSITION_X={1+12.125, 1+24.25+0.5+12.125, 1+24.25+0.5+24.25+0.5+12.125};
    private double x;
    private double y;
    private double halfWidth=12.125;
    private double halfHeight=13.5;
    private Random rand= new Random();

    public Tiles(){
        x= POSITION_X[rand.nextInt(3)];
        y= 100+halfHeight;
    }

    public boolean touched(){
        if(StdDraw)
    }

    public void pintar(){
        for(double i=y;i<0 && !touched; i--){
            Figura f= new Figura();
            f.roundedCornersRectangle(x,y,halfWidth,halfHeight);
        }
    }

    public double getY(){
        return y;
    }

    public double getHalfHeight(){
        return halfHeight;
    }
}
