package equivalencia.main;

public class Atleta extends Persona {
    // De cada atleta se conocen la masa muscular (que comienza en 4 kilos) y la cantidad de técnicas que conoce (que comienza en 2).
    // La potencia de un atleta es la suma del valor de potencia para todas las personas, con la multiplicación entre masa muscular y cantidad de técnicas que conoce.
    // Un atleta es destacado si cumple la condición común para todas las personas, o bien, conoce más de 5 técnicas.

    private int masaMuscular; //arranca en 4 
    private int tecnicasConocidas; //arranca en 2

    public Atleta(int edad, String nombre) {
        super(edad,nombre);
        this.masaMuscular = 4; 
        this.tecnicasConocidas = 2;
    }

    public Atleta(int edad, String nombre, int masaMuscular, int tecnicasConocidas) {
        super(edad,nombre);
        this.masaMuscular = masaMuscular==0 ? 4 : masaMuscular;
        this.tecnicasConocidas = tecnicasConocidas==0 ? 2 : tecnicasConocidas;
    }

    @Override
    public int getPotencia() { 
        return super.getPotencia() + (this.masaMuscular*this.tecnicasConocidas);
    }

    @Override 
    public boolean esDestacada() { 
        return super.esDestacada() || this.tecnicasConocidas > 5;
    }

    // entrenar una cantidad de días: el efecto es sumar a la masa muscular 1 kilo por cada 5 días de entrenamiento. P.ej. el efecto de entrenar 15 días, es sumar 3 kilos a la masa muscular.
    // aprender una técnica: el efecto es sumar uno a la cantidad de técnicas que conoce el atleta.

    public void entrenar (int dias) { 
        this.masaMuscular = this.masaMuscular + (dias/5);
    }

    public void aprenderTecnica() { 
        this.tecnicasConocidas++;
    }

    public int getMasaMuscular() {
        return masaMuscular;
    }

    public int getTecnicasConocidas() {
        return tecnicasConocidas;
    }



}
