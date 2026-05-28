package modelo.objetos;

import stdlib.*;
import modelo.Interfaz;

public class Anuncio extends ImageSequence{

    public Anuncio(){
        super(35,"anuncio","jpeg",100);
    }

    public void reproduceFrame(Interfaz in){
        for(int i=1;i<36;i++){
            StdDraw.picture(50,50,frame.peek());
            frame.poll();
            StdDraw.setPenColor(StdDraw.YELLOW);
            StdDraw.text(50,50,"Reproduciendo anuncio...");
            StdDraw.show();
            StdDraw.pause(pasoMsFrame);
        }
    }
}
