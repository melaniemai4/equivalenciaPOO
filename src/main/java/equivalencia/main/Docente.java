package equivalencia.main;

public class Docente extends Persona {
    // De cada docente se conoce la cantidad de cursos que dio, que arranca en 0.
    // La inteligencia de un docente es la suma del valor común para todas las personas, con el doble de la cantidad de cursos que dio.
    // Un docente es destacado si dio más de 3 cursos.
    // ¡Atención! la condición general para considerar a una persona como destacada no corre para los docentes, o sea, un docente que haya dado 3 o menos cursos nunca es destacado, aunque tenga p.ej. 25 años.
    
    private int cursosDados;
        
    public Docente(int edad, String nombre) {
        super(edad,nombre);
        cursosDados = 0; 
    }

    public Docente(int edad, String nombre, int cantCursos) {
        super(edad,nombre);
        this.cursosDados = cantCursos;
    }

    @Override
    public int getInteligencia() { //la suma del valor común para todas las personas, con el doble de la cantidad de cursos que dio.
        return super.getInteligencia() + (cursosDados*2);
    }

    @Override
    public boolean esDestacada() { //si dio más de 3 cursos. cond. general no corre para los docentes
        return cursosDados>3;
    }

    @Override
    public int getValor() { //potencia+inteligencia+5 extra
        return this.getPotencia() + this.getInteligencia() + 5;
    }

}
