package equivalencia.main;

import java.util.HashSet;
import java.util.Set;

public class Soldado extends Persona {
    private Set<Arma> coleccionArmas;

    public Soldado(int edad,String nombre) {
        super(edad,nombre);
        this.coleccionArmas = new HashSet<>();
    }

    public Soldado(int edad, String nombre, Set<Arma> armas) {
        super(edad, nombre);
        this.coleccionArmas = armas;
    }

    @Override
    public int getPotencia() {
        int potenciaTotal = super.getPotencia();
        for (Arma arma : coleccionArmas) {
            potenciaTotal = potenciaTotal + arma.getPotencia(super.getEdad()); 
        }
        return potenciaTotal;
    }
}
