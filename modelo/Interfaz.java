package modelo;

import java.awt.Color;
import stdlib.StdDraw;
import modelo.objetos.*;

public class Interfaz {

    // ATRIBUTOS
    private static final int XMAX = 600;
    private static final int YMAX = 600;
    private static final int ESCALA = 100;
    private static final Color DEFAULT_COLOR = StdDraw.BLACK;
    public static final int PASO_MS = 50;

    private int interfaz;
    private int points;
    private int dificulty;
    private int cambioDeVelocidadCadaX = 1; // cada x puntos aumenta la velocidad
    private boolean teclaIncorrectaAntes; // Para evitar debounce entre frames
    
    // FUNCIONES BÁSICAS

    public Interfaz() {
        interfaz = 0;
        points = 0;
    }

    public void siguienteInterfaz(int i) {
        interfaz = i;
    }

    /* Correción del proyecto: uso de la HERENCIA para distinguir los elementos hijos de un mismo padre*/
    public void siguienteInterfaz(Boton b){
        if(b instanceof BotonPlay)
            interfaz=1;
        if(b instanceof BotonFacil){
            interfaz=2;
            setDificulty(0);;
        }
        if(b instanceof BotonDificil){
            interfaz=2;
            setDificulty(1);;
        }
        if(b instanceof BotonAd)
            interfaz= 6;
        if(b instanceof BotonNo)
            interfaz= 5;
    }

    // INICIAR GRÁFICOS
    public void iniciarGraficos() {
        StdDraw.enableDoubleBuffering();
        StdDraw.setCanvasSize(XMAX, YMAX);
        StdDraw.setScale(0, ESCALA);
        StdDraw.setPenColor(DEFAULT_COLOR);
    }

    public void clearScreen() {
        StdDraw.clear(StdDraw.PINK);
        StdDraw.picture(50, 50, "blueGradient.jpg");
    }

    public void gameGraphics() {
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        StdDraw.line(1 + 24.25, 100, 1 + 24.25, 0);
        StdDraw.line(1 + 24.25 + 0.5 + 24.25, 100, 1 + 24.25 + 0.5 + 24.25, 0);
        StdDraw.line(1 + 24.25 + 0.5 + 24.25 + 0.5 + 24.25, 100, 1 + 24.25 + 0.5 + 24.25 + 0.5 + 24.25, 0);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(1 + 12.125, 7, "D");
        StdDraw.text(1 + 24.25 + 0.5 + 12.125, 7, "F");
        StdDraw.text(1 + 24.25 + 0.5 + 24.25 + 0.5 + 12.125, 7, "J");
        StdDraw.text(1 + 24.25 + 0.5 + 24.25 + 0.5 + 24.25 + 0.5 + 12.125, 7, "K");
        StdDraw.show();
    }

    // OTRAS FUNCIONES ÚTILES

    public void setDificulty(int i) {
        dificulty = i;
        if (dificulty == 0) {
            velocidadTiles = 1.0;
            cambioDeVelocidadCadaX = 8;
        }
        if (dificulty == 1) {
            velocidadTiles = 1.5;
            cambioDeVelocidadCadaX = 4;
        }
    }

    public void addPoints() {
        points += 1;
        if (getPoints() % cambioDeVelocidadCadaX == 0)
            velocidadTiles += 0.1; // DIFICULTAD DEL JUEGO
    }

    // GETTERS

    public boolean isAnuncioUsado() {
        return anuncioUsado;
    }

    public int getPoints() {
        return points;
    }

    // CREAR OBJETOS
    BotonPlay botonPlay = new BotonPlay(50, 40, 10, 3);
    BotonFacil facil = new BotonFacil("Begginer", 27, 45, 19, 35);
    BotonDificil dificil = new BotonDificil("Hardcore", 73, 45, 19, 35);
    BotonAd botonAd = new BotonAd("Sí", 30, 45, 10, 5);
    BotonNo botonNo = new BotonNo("No", 70, 45, 10, 5);
    BarraScore barraScore = new BarraScore();
    HealthPoints hp = new HealthPoints(5);
    Line l = new Line();
    Boolean anuncioUsado = false;

    // INTERFACES

    // 0. Panel de inicio
    public void home() {
        clearScreen();
        StdDraw.picture(50, 50, "HomeScreen.png");

        botonPlay.mouse();
        botonPlay.interaccion(this);

        StdDraw.show();
        StdDraw.pause(PASO_MS);
    }

    // 1. Opciones menu
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

    // 2. Cuenta atrás
    public void temporizador() {
        StdDraw.setPenColor(StdDraw.BLACK);
        for (int i = 3; i >= 0; i--) {
            clearScreen();
            StdDraw.text(50, 48, "Controls: D,F,J,K");
            StdDraw.text(50, 52, i + "");
            StdDraw.pause(1000);
            StdDraw.show();
        }
        siguienteInterfaz(3);

    }

    // 3. game
    Tiles t = new Tiles();
    private double velocidadTiles = 1.5;

    public void game() {
        clearScreen();
        gameGraphics();
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(10, 90, "Score: " + points);
        barraScore.pintar(this);
        hp.dibujar();
        l.pintar();

        t.actualizar(velocidadTiles);
        t.touched(hp);
        t.pintar();

        // Pulsado
        if (t.isTouched()) {
            addPoints();
            t = new Tiles();
        }

        // Missed

        boolean teclaIncorrecta = t.wrongKeyPressed();
        if (t.overLine()) {
            if (teclaIncorrecta && !teclaIncorrectaAntes) {
                t.setPenalizadoAntes(true);
                hp.perderVida();
                t = new Tiles();
            }
            teclaIncorrectaAntes = teclaIncorrecta;
        }

        if (t.afterLine() && !t.getPenalizadoAntes()) {
            if (!t.isTouched())
                hp.perderVida();
            t = new Tiles(); // nuevo tile si el tile ha desaparecido
        }

        // Game over
        if (hp.getVidasActuales() == 0) {
            if (!anuncioUsado) siguienteInterfaz(4); // primera vez, al popUp
            else siguienteInterfaz(5); // segunda vez, game over directo
        }

        StdDraw.show();
        StdDraw.pause(PASO_MS);
    }

    // 4. Pop up
    public void popUp() {
        clearScreen();

        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledRectangle(50, 50, 20, 13);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(50, 57, "¿Desea restaurar el progreso?");

        botonAd.mouse();
        botonNo.mouse();

        botonAd.interaccion(this);
        botonNo.interaccion(this);

        StdDraw.show();
        StdDraw.pause(PASO_MS);
    }

    // 5. Game over
    public void gameOver() {
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledSquare(50, 50, 25);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.text(50,55,"Game over");
        StdDraw.text(50,45,"Points obtained: "+ points);
        StdDraw.show();
        StdDraw.pause(PASO_MS);
    }

    // 6. Anuncio
    public void anuncio() {
        clearScreen();

        Anuncio ad= new Anuncio();
        ad.reproduceAd();

        anuncioUsado = true;
        hp.ganarVida();
        t = new Tiles();

        siguienteInterfaz(2); // Volver al juego
    }

    // JUEGO
    public void juego() {
        iniciarGraficos();
        while (true) {
            if (interfaz == 0)
                home();
            if (interfaz == 1)
                menu();
            if (interfaz == 2)
                temporizador();
            if (interfaz == 3)
                game();
            if (interfaz == 4)
                popUp();
            if (interfaz == 5)
                gameOver();
            if (interfaz == 6)
                anuncio();
        }
    }
}
