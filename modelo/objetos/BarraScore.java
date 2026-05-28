package modelo.objetos;

import modelo.Interfaz;
import stdlib.StdDraw;

public class BarraScore extends Barra {

    public BarraScore(){
        super(13, "Score",18,95,11,2);
    }

    @Override
    public void moverContador(Interfaz i) {
        if(i.getPoints()<=maxAtributo){
            StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
            roundedCornersRectangle(i.getPoints()/2+ 8, y, i.getPoints(), halfHeight-0.5);    
        }
        else{
            StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
            roundedCornersRectangle(x, y, maxAtributo, halfHeight-0.5);
        }
    }

    @Override
    public void pintar(Interfaz i) {
        StdDraw.setPenColor(StdDraw.WHITE);
        roundedCornersRectangle(x, y, halfWidth, halfHeight);
        moverContador(i);
    }
    
}
