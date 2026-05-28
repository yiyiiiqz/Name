package modelo.objetos;

import stdlib.*;
import modelo.Interfaz;

public class Countdown extends ImageSequence {

    public Countdown(){
        super(3,"countdown","png",1000);
    }

    public void reproduceFrame(Interfaz in){
        for(int i=1;i<nFrame+1;i++){
            in.clearScreen("MoonlightMelodyBackground.png");
            StdDraw.picture(50,55,frame.peek());
            frame.poll();
            StdDraw.picture(50,45,"Controls.png",30,10);
            StdDraw.show();
            StdDraw.pause(pasoMsFrame);
        }
    }
}
