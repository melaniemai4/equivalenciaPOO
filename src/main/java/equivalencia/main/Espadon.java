package equivalencia.main;

public class Espadon extends Arma {
    
    private int pesoKG;

    public Espadon(int pesoKG) {
        super();    
        this.pesoKG = pesoKG;
    }

    @Override
    public int getPotencia(int edad) {
        if (edad<40) {
            return this.pesoKG/2;
        } else {
            return 6;
        }
    }
}
