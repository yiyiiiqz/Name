package modelo.objetos;
import stdlib.StdDraw;

public class BotonPlay extends Boton{

    public BotonPlay(String s, double x, double y, double ancho, double alto){
        super(s, x, y, ancho, alto);
    }
    
    @Override
    public void pintar() {
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.rectangle(x,y,ancho/2,alto/2);
        StdDraw.text(x, y, "Play");
        StdDraw.show();
    }

    @Override
    public void mouse() {

    }

    @Override
    public void interaccion() {

    } 
}
