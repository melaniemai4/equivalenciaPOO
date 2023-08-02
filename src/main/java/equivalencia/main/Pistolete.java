package equivalencia.main;

public class Pistolete extends Arma {

    private int largoCM;

    public Pistolete(int largocm) {
        super();    
        this.largoCM = largocm;
    }

    @Override
    public int getPotencia(int edad) {
        if (edad>30) {
            return this.largoCM*3;
        } else {
            return this.largoCM*2;
        }
    }
    
}
