package modelo.objetos;
import modelo.Interfaz;

public class BarraScore extends Barra {

    public BarraScore(){
        super(30, "Score");
    }

    @Override
    public void moverContador(Interfaz i) {
        while(i.points<=maxAtributo){
            roundedCornersRectangle(0, 0, i.points, halfHeight-2);    
        }
    }

    @Override
    public void pintar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pintar'");
    }
    
}
