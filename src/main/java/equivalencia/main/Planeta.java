package equivalencia.main;

import java.util.HashSet;
import java.util.Set;

public class Planeta {
    //De cada planeta se conocen los habitantes, que son personas. También la cantidad de museos que hay en el planeta.
    //Se tiene que poder obtener, para cada planeta

    //la delegación diplomática, que está formada por los habitantes destacados.
    //el valor inicial de defensa, que es la cantidad de habitantes que tienen, al menos, 30 unidades de potencia.
    //si es culto: la condición es que haya al menos dos museos, y que todos los habitantes tengan al menos 10 unidades de inteligencia.
    //la potencia real: es la suma de la potencia de todos los habitantes.

    private Set<Persona> habitantes;
    private int cantMuseos;
    private int longMurallaTotalKM;
    

    public Planeta() {
    }

    public Planeta(Set<Persona> habitantes, int cantMuseos) {
        this.habitantes = habitantes;
        this.cantMuseos = cantMuseos;
    }

    public void contruirMurallas(int cantKilometrosSumados) {
        this.longMurallaTotalKM = longMurallaTotalKM + cantKilometrosSumados;
    }

    public void fundarMuseo() {
        this.cantMuseos++;
    }

    public Set<Persona> getDelegacionDiplomatica(){
        Set<Persona> retDelegacion=new HashSet<>();
        for (Persona p : this.habitantes) {
            if (p.esDestacada())
                retDelegacion.add(p);
        }
        return retDelegacion;
    }

    public int getValorDefensa() {
        int defensa = 0;
        for (Persona p : this.habitantes) {
            if (p.getPotencia()>30)
                defensa++;
        }
        return defensa;
    }

    public boolean esCulto() {
        boolean todosInteligentes = true;
        for (Persona p : this.habitantes) {
            if (p.getInteligencia() <= 10){
                todosInteligentes = false; //alguno con 10 o menos ya no cumple
            }
        }
        return (cantMuseos>2 && todosInteligentes);
    }

    public int getPotenciaReal() {
        int potenciaReal = 0;
         for (Persona p : this.habitantes) {
            potenciaReal+=p.getPotencia();
        }
        return potenciaReal;
    }

    public int getPotenciaAparente(){
        int potenciaMasPotente = 0;
        for (Persona p : this.habitantes){
            if (p.getPotencia()>potenciaMasPotente) {
                potenciaMasPotente = p.getPotencia()*habitantes.size();
            }
        }
        return potenciaMasPotente;
    }

    public boolean necesitaReforzarse() {
        return (this.getPotenciaAparente()*2 >= this.getPotenciaReal());
    }

    public void recibirTributos() {
        for (Persona p : this.habitantes) {
            if(p.getClass().equals(Atleta.class)) {
                this.contruirMurallas(2); // atleta construir 2 kilómetros de murallas
            } else if (p.getClass().equals(Docente.class)) {
                this.fundarMuseo();
            } else if (p.getClass().equals(Soldado.class)) {
            this.contruirMurallas(5); 
            }
        }
    }
    
    public void recibirTributoExtraPlanetario(Persona contribuyente) {
        if(contribuyente.getClass().equals(Atleta.class)) {
            this.contruirMurallas(2); 
        } else if (contribuyente.getClass().equals(Docente.class)) {
            this.fundarMuseo();
        } else if (contribuyente.getClass().equals(Soldado.class)) {
            this.contruirMurallas(5); 
        }
    }

    public Set<Persona> getHabitantesValiosos() {
        Set<Persona> retHabValiosos=new HashSet<>();
        for (Persona p : this.habitantes) {
            if (p.getValor() >= 40){
                retHabValiosos.add(p);
            }
        }
        return retHabValiosos;

    }

    public void apaciguarPlaneta(Planeta planetaAapaciguar) {
        Set<Persona> habValiosos = this.getHabitantesValiosos();
        for (Persona p : habValiosos) {
            planetaAapaciguar.recibirTributoExtraPlanetario(p);
        }
    }

    public Set<Persona> getHabitantes() {
        return habitantes;
    }

    public int getCantMuseos() {
        return cantMuseos;
    }

    public int getLongMurallaTotalKM() {
        return longMurallaTotalKM;
    }

}
