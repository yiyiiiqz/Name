package modelo.objetos;
import stdlib.StdDraw;
import modelo.*;

public class BotonPlay extends Boton{

    public BotonPlay(double x, double y, double halfWidth, double halfHeight){
        super("Play", x, y, halfWidth, halfHeight);
    }
    
    @Override
    public void pintar() {
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.rectangle(x,y,halfWidth,halfHeight);
        StdDraw.text(x, y, name);
    }

    @Override
    public void mouse() {
        if(overFigure()){
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.filledRectangle(x,y,halfWidth,halfHeight);
            StdDraw.setPenColor(StdDraw.PINK);
            StdDraw.text(x, y, name);
        }
        else{
            pintar();
        }
    }

    @Override
    public void interaccion(Interfaz i) {
        if(StdDraw.mousePressed() && overFigure()){
            while(StdDraw.mousePressed()) StdDraw.pause(20);
            //Añadir animación+ sonido
            i.siguienteInterfaz(this);
        }
    }
}
