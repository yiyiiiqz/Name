package modelo;

import java.awt.Color;
import stdlib.StdDraw;
import modelo.objetos.*;

public class Interfaz {

    //Atributos
    public static final int XMAX = 600;
    public static final int YMAX = 600;
    public static final int ESCALA = 100;
    public static final Color DEFAULT_COLOR = StdDraw.BLACK;
    // public static final int ESPACIO = 32; 
    public static final int PASO_MS = 50; 

    public int interfaz;

    public Interfaz(){
        interfaz=0;
    }

    public void siguienteInterfaz(){
        interfaz+=1;
    }

    //Iniciar gráficos
    public void iniciarGraficosJuego(){
        StdDraw.enableDoubleBuffering();
        StdDraw.setCanvasSize(XMAX, YMAX);
        StdDraw.setScale(0, ESCALA);
        // StdDraw.setPenRadius(5);
        StdDraw.setPenColor(DEFAULT_COLOR);
    }

    /*public void iniciarGraficosHome(){
        StdDraw.clear();
        StdDraw.picture(50,50,"pinkBackground.jpeg");
        StdDraw.text(50,75,"Tiles");
    }*/


    // 1. Panel de inicio
    public void home(){
        StdDraw.clear();
        StdDraw.picture(50,50,"pinkBackground.jpeg");
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(50,75,"Tiles");
        BotonPlay b= new BotonPlay(50, 50, 24, 12);
        b.mouse();
        b.interaccion(this);
        StdDraw.show();
        StdDraw.pause(PASO_MS);
    }

    // Juego
    public void juego(){
        iniciarGraficosJuego();
        while(interfaz==0) home();
    }
}
