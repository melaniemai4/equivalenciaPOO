package equivalencia.main;

//uso clase abstracta en vez de interfaz ya que la 2da solo puede tener variables estaticas
//y con clase abstracta puedo declarar constructores 
public class Persona { 

    // De cada persona se registra su edad, o sea cuántos años tiene. Deben poder obtenerse: la potencia, la inteligencia y si es o no destacado de cada personas. Potencia e inteligencia son dos valores numéricos. En principio, corresponden estas definiciones:
    // la inteligencia es de 12 para las personas de entre 20 y los 40 años, y de 8 para las otras.
    // la potencia es de 20 para todas las personas.
    // una persona es destacada si tiene, exactamente, 25 ó 35 años. O sea, si una persona tiene 25 años es destacada, si tiene 35 años es destacada, si tiene cualquier otra edad no es destacada.

    private int edad;
    private String nombre;

    public Persona() {
    }

    public Persona(int edad, String nombre) {
        this.edad = edad;
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public int getInteligencia() {
        return (edad > 20 && edad < 40) ? 12 : 8;
    }

    public int getPotencia() {
        return 20;
    }

    public boolean esDestacada() {
        return edad == 25 || edad == 35;
    }

    public int getValor() {
        return this.getPotencia() + this.getInteligencia();
    }

    public String getNombre() {
        return nombre;
    }

    
}
