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
    public void iniciarGraficos(){
        StdDraw.enableDoubleBuffering();
        StdDraw.setCanvasSize(XMAX, YMAX);
        StdDraw.setScale(0, ESCALA);
        // StdDraw.setPenRadius(5);
        StdDraw.setPenColor(DEFAULT_COLOR);
    }

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

    //2. Opciones menu
    public void menu(){
        StdDraw.clear();
        StdDraw.picture(50,50,"pinkBackground.jpeg");
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(50, 90, "Choose the mode");
        

        BotonFacil facil = new BotonFacil("Begginer", 27, 45, 38, 70);
        facil.pintar();
        BotonDificil dificil = new BotonDificil("Hardcore", 73, 45, 38, 70);
        dificil.pintar();

        StdDraw.show();
        StdDraw.pause(PASO_MS);
    }

    // Juego
    public void juego(){
        iniciarGraficos();
        while(interfaz==0) home();
        while(interfaz==1) menu();
    }
}
