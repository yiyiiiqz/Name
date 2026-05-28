package modelo.objetos;

import tads.*;
import modelo.Interfaz;

public abstract class ImageSequence {
    protected int pasoMsFrame = 100;
    protected IQueue<String> frame;
    protected int nFrame;
    protected String p;
    protected String type;

    public ImageSequence(int nFrame, String p, String type, int n){
        frame= new ArrayQueue<>();
        this.nFrame= nFrame;
        this.p=p;
        this.type= type;
        pasoMsFrame=n;
        for(int i=1;i<nFrame+1;i++){
            frame.add(p + "/"+i+"."+type);
        }
    }

    protected abstract void reproduceFrame(Interfaz in);
}
