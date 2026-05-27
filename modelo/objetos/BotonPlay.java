package modelo.objetos;
import stdlib.StdDraw;
import modelo.*;

public class BotonPlay extends Boton{

    private String defaultImage = "MoonlightMelodyButtonPlay.png";
    private String hoverImage = "MoonlightMelodyButtonPlayHover.png";

    public BotonPlay(double x, double y, double halfWidth, double halfHeight){
        super("Play", x, y, halfWidth, halfHeight);
    }
    
    @Override
    public void pintar() {
        StdDraw.picture(x,y,defaultImage, halfWidth*2,halfHeight*2);
    }

    @Override
    public void mouse() {
        if(overFigure()){
            StdDraw.picture(x,y,hoverImage,halfWidth*2,halfHeight*2);
        }
        else{
            pintar();
        }
    }

    @Override
    public void interaccion(Interfaz i) {
        if(StdDraw.mousePressed() && overFigure()){
            while(StdDraw.mousePressed()) StdDraw.pause(20);
            i.siguienteInterfaz(this);
        }
    }
}
