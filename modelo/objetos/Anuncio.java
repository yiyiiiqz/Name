package modelo.objetos;

import stdlib.*;
import tads.*;

public class Anuncio {
    static final int PASO_MS_ANUNCIO = 100;
    private IQueue<String> frame;

    public Anuncio(){
        frame= new ArrayQueue<>();
        for(int i=1;i<36;i++){
            frame.add("anuncio/"+i+".jpeg");
        }
    }

    public void reproduceAd(){
        for(int i=1;i<36;i++){
            StdDraw.picture(50,50,frame.peek());
            frame.poll();
            StdDraw.setPenColor(StdDraw.YELLOW);
            StdDraw.text(50,50,"Reproduciendo anuncio...");
            StdDraw.show();
            StdDraw.pause(PASO_MS_ANUNCIO);
        }
    }
}
