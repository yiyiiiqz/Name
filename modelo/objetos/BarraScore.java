package modelo.objetos;
import modelo.Interfaz;
import stdlib.StdDraw;

public class BarraScore extends Barra {

    public BarraScore(){
        super(13, "Score",18,95,11,3);
    }

    @Override
    public void moverContador(Interfaz i) {
        if(i.points<=maxAtributo){
            StdDraw.setPenColor(StdDraw.BLUE);
            roundedCornersRectangle(i.points/2+ 8, y, i.points, halfHeight-2);    
        }
        else{
            StdDraw.setPenColor(StdDraw.BLUE);
            roundedCornersRectangle(x, y, maxAtributo, halfHeight-2);
        }
    }

    @Override
    public void pintar(Interfaz i) {
        StdDraw.setPenColor(StdDraw.GRAY);
        roundedCornersRectangle(x, y, halfWidth, halfHeight);
        StdDraw.setPenColor(StdDraw.WHITE);
        roundedCornersRectangle(x, y, halfWidth-0.5, halfHeight-0.5);
        moverContador(i);
    }
    
}
