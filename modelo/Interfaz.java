package modelo;

import java.awt.Color;
import stdlib.StdDraw;
import modelo.objetos.*;

public class Interfaz {

    // Atributos
    public static final int XMAX = 600;
    public static final int YMAX = 600;
    public static final int ESCALA = 100;
    public static final Color DEFAULT_COLOR = StdDraw.BLACK;
    // public static final int ESPACIO = 32;
    public static final int PASO_MS = 50;

    public int interfaz;
    public int dificulty;
    public int points;

    public Interfaz() {
        interfaz = 0;
        points=0;
    }

    public void siguienteInterfaz(int i) {
        interfaz = i;
    }

    // Iniciar gráficos
    public void iniciarGraficos() {
        StdDraw.enableDoubleBuffering();
        StdDraw.setCanvasSize(XMAX, YMAX);
        StdDraw.setScale(0, ESCALA);
        // StdDraw.setPenRadius(5);
        StdDraw.setPenColor(DEFAULT_COLOR);
    }

    public void clearScreen() {
        StdDraw.clear();
        StdDraw.picture(50, 50, "pinkBackground.jpeg");
    }

    // Otras funciones útiles
    public void setDificulty(int i) {
        dificulty = i;
    }

    public void addPoints(){
        points+=1;
    }

    // Crear objetos
    BotonPlay botonPlay = new BotonPlay(50, 50, 12, 6);
    BotonFacil facil = new BotonFacil("Begginer", 27, 45, 19, 35);
    BotonDificil dificil = new BotonDificil("Hardcore", 73, 45, 19, 35);
    BarraScore barraScore = new BarraScore();
    HealthPoints hp = new HealthPoints(5);
    Line l= new Line();

    // 1. Panel de inicio
    public void home() {
        clearScreen();
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(50, 75, "Tiles");

        botonPlay.mouse();
        botonPlay.interaccion(this);

        StdDraw.show();
        StdDraw.pause(PASO_MS);
    }

    // 2. Opciones menu
    public void menu() {
        clearScreen();
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(50, 90, "Choose the mode");
        facil.mouse();
        dificil.mouse();
        facil.interaccion(this);
        dificil.interaccion(this);

        StdDraw.show();
        StdDraw.pause(PASO_MS);
    }

    // 3. game
    public void game() {
        clearScreen();
        barraScore.pintar(this);

        //Vidas (corazones)
        //hp.perderVida(); // Prueba de perder vida
        //while (true) {
        hp.dibujar();
            //StdDraw.show();
            //StdDraw.pause(20);
        //}
        l.pintar();
        for(int i=0;i<4;i++){
            Tiles t= new Tiles();
            t.pintar(this, hp);
        }
        StdDraw.show();
        StdDraw.pause(PASO_MS);
    }

    // Juego
    public void juego() {
        iniciarGraficos();
        while (true) {
            if (interfaz == 0)
                home();
            if (interfaz == 1)
                menu();
            if (interfaz == 2)
                game();
        }
    }
}
