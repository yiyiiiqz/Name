package modelo.objetos;
import stdlib.StdDraw;
import modelo.*;

public class BotonPlay extends Boton{

    public BotonPlay(double x, double y, double ancho, double alto){
        super("Play", x, y, ancho, alto);
    }
    
    @Override
    public void pintar() {
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.rectangle(x,y,ancho/2,alto/2);
        StdDraw.text(x, y, name);
        StdDraw.show();
    }

    @Override
    public void mouse() {
        if(overButton()){
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.filledRectangle(x,y,ancho/2,alto/2);
            StdDraw.setPenColor(StdDraw.PINK);
            StdDraw.text(x, y, name);
            StdDraw.show();
        }
        else{
            pintar();
        }
    }

    @Override
    public void interaccion(Interfaz i) {
        if(StdDraw.mousePressed() && overButton()){
            //Añadir animación+ sonido
            i.siguienteInterfaz();
        }
    }
}
