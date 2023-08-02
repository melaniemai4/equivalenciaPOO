package equivalencia;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import equivalencia.main.Arma;
import equivalencia.main.Atleta;
import equivalencia.main.Docente;
import equivalencia.main.Espadon;
import equivalencia.main.Persona;
import equivalencia.main.Pistolete;
import equivalencia.main.Planeta;
import equivalencia.main.Soldado;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void testEscenarioBasico() {
        Persona julieta = new Persona(42, "Julieta");
        testPersona(julieta, 20, 8, false);

        Atleta ana = new Atleta(25, "Ana");
        testPersona(ana, 28, 12, true);

        Atleta rosa = new Atleta(45, "Rosa", 0, 8);
        testPersona(rosa, 52, 8, true);

        Atleta perla = new Atleta(28, "Perla", 6, 4);
        testPersona(perla, 44, 12, false);

        Docente monica = new Docente(45, "Monica", 6);
        testPersona(monica, 20, 20, true);

        Docente luisa = new Docente(35, "Luisa", 1);
        testPersona(luisa, 20, 14, false);

    }

    public void testPersona(Persona persona, int expectedPotencia, int expectedInteli, boolean expectedDest) {
        assertEquals(persona.getNombre() + " potencia", expectedPotencia, persona.getPotencia());
        assertEquals(persona.getNombre() + " inteligencia", expectedInteli, persona.getInteligencia());
        assertEquals(persona.getNombre() + " destacada", expectedDest, persona.esDestacada());
    }
    
    @Test
    public void testEscenarioBasico2() {
        Persona julieta = new Persona(42, "Julieta");
        Atleta ana = new Atleta(25, "Ana");
        Atleta rosa = new Atleta(45, "Rosa", 0, 8);
        Atleta perla = new Atleta(28, "Perla", 6, 4);
        Docente monica = new Docente(45, "Monica", 6);
        Docente luisa = new Docente(35, "Luisa", 1);

        Set<Persona> listaHabitantes = new HashSet<>();

        listaHabitantes.add(julieta);
        listaHabitantes.add(ana);
        listaHabitantes.add(rosa);
        listaHabitantes.add(perla);
        listaHabitantes.add(monica);
        listaHabitantes.add(luisa);

        Planeta triton = new Planeta(listaHabitantes, 1);
        testPlaneta(triton);
    }

    @Test
    public void testPerlaEntrena() {
        Atleta perla = new Atleta(28, "Perla", 6, 4);
        assertEquals("la potencia de Perla es de 44", 44, perla.getPotencia());
        perla.entrenar(15);
        perla.aprenderTecnica();
        assertEquals("la potencia de Perla es de 65", 65, perla.getPotencia());
        assertFalse("no es destacada", perla.esDestacada());
        perla.aprenderTecnica();
        assertTrue("es destacada", perla.esDestacada());

    }



    public void testPlaneta(Planeta planeta) {
        testDelegacionDiplomatica(planeta.getDelegacionDiplomatica(), "Ana", true); // la delegación diplomática está
                                                                                    // formada por Ana, Rosa y Mónica
        testDelegacionDiplomatica(planeta.getDelegacionDiplomatica(), "Rosa", true);
        testDelegacionDiplomatica(planeta.getDelegacionDiplomatica(), "Monica", true);
        testDelegacionDiplomatica(planeta.getDelegacionDiplomatica(), "Julieta", false);

        assertTrue("valor inicial de defensa ", planeta.getValorDefensa() == 2); // el valor inicial de defensa es 2
        assertFalse("valor inicial de defensa ", planeta.getValorDefensa() == 3);

        assertFalse("es un planeta culto", planeta.esCulto()); // no es un planeta culto

        assertEquals("la potencia real es 184", 184, planeta.getPotenciaReal()); // la potencia real es 184
        assertFalse("la potencia real es 184", planeta.getPotenciaReal() == 186);
    }

    public void testDelegacionDiplomatica(Set<Persona> delegacion, String nombre, boolean expected) {
        assertEquals(delegacion.stream().anyMatch(p -> p.getNombre().equals(nombre)), expected);
    }

    @Test
    public void testMasSobrePlaneta() {
        Persona julieta = new Persona(42, "Julieta");
        Atleta ana = new Atleta(25, "Ana");
        Atleta rosa = new Atleta(45, "Rosa", 0, 8);
        Atleta perla = new Atleta(28, "Perla", 6, 4);
        Docente monica = new Docente(45, "Monica", 6);
        Docente luisa = new Docente(35, "Luisa", 1);

        Set<Persona> listaHabitantes = new HashSet<>();

        listaHabitantes.add(julieta);
        listaHabitantes.add(ana);
        listaHabitantes.add(rosa);
        listaHabitantes.add(perla);
        listaHabitantes.add(monica);
        listaHabitantes.add(luisa);

        Planeta triton = new Planeta(listaHabitantes, 1);
        assertTrue("triton necesita reforzarse", triton.necesitaReforzarse()); // usa potencia real y aparente

        assertEquals("cant museos antes de tributos", 1, triton.getCantMuseos());
        assertEquals("cant km muralla antes de tributos", 0, triton.getLongMurallaTotalKM());
        triton.recibirTributos();
        // 2 museos construidos, 3 personas agregaron 2 km de muralla
        assertEquals("cant museos antes de tributos", 3, triton.getCantMuseos());
        assertEquals("cant km muralla antes de tributos", 6, triton.getLongMurallaTotalKM());
    }

    @Test
    public void testValorDePersonas() {
        // suma la potencia y la inteligencia de cada persona. los docentes tienen 5 adicionales
        Persona julieta = new Persona(42, "Julieta"); //20+8
        Atleta ana = new Atleta(25, "Ana"); //28+12
        Docente monica = new Docente(45, "Monica", 6); //20+20+5

        Set<Persona> listaHabitantes = new HashSet<>();

        listaHabitantes.add(julieta);
        listaHabitantes.add(ana);
        listaHabitantes.add(monica);

        assertEquals("valor de julieta", 28, julieta.getValor());
        assertEquals("valor de ana", 40, ana.getValor());
        assertEquals("valor de monica", 45, monica.getValor());

        Planeta tierra = new Planeta(listaHabitantes, 2);

        assertEquals("es habitante valioso", false, tierra.getHabitantesValiosos().stream().anyMatch(p -> p.getNombre().equals("Julieta")));
        assertEquals("es habitante valioso", true, tierra.getHabitantesValiosos().stream().anyMatch(p -> p.getNombre().equals("Ana")));
        assertEquals("es habitante valioso", true, tierra.getHabitantesValiosos().stream().anyMatch(p -> p.getNombre().equals("Monica")));

    }

    @Test
    public void testApaciguarPlaneta() {
        Atleta ana = new Atleta(25, "Ana"); 
        Docente monica = new Docente(45, "Monica", 6); 
        Atleta perla = new Atleta(28,"Perla",6,4);    

        Set<Persona> listaHabitantes = new HashSet<>();

        listaHabitantes.add(ana); //valiosa, suma 2 km
        listaHabitantes.add(monica); //valiosa, suma 1 museo
        listaHabitantes.add(perla); //valiosa, suma 2 km
        Planeta triton = new Planeta(listaHabitantes, 2);

        Set<Persona> list2 = new HashSet<>();
        Persona rosana = new Persona(20,"Rosana");
        Atleta claudia = new Atleta(30,"Claudia");    
        list2.add(rosana);
        list2.add(claudia);
        Planeta paleas = new Planeta(list2,0);

        assertEquals("cant museos de paleas antes de tributos", 0, paleas.getCantMuseos());
        assertEquals("cant km muralla de paleas antes de tributos", 0, paleas.getLongMurallaTotalKM());

        triton.apaciguarPlaneta(paleas);
    // todos los habitantes valiosos de triton tributan a paleas
        assertEquals("cant museos de paleas antes de tributos", 1, paleas.getCantMuseos());
        assertEquals("cant km muralla de paleas antes de tributos", 4, paleas.getLongMurallaTotalKM());

    }

    @Test
    public void testSoldados() {
        Espadon armaEspadon1 = new Espadon(6);
        Pistolete armaPistolete1 = new Pistolete(15);
        Set<Arma> armasS1 = new HashSet<>();
        armasS1.add(armaEspadon1);
        armasS1.add(armaPistolete1);
        Soldado ruben = new Soldado(20, "Ruben", armasS1);

        assertEquals("ruben 20 años, pistolete 15 cm --> el doble", 30, armaPistolete1.getPotencia(ruben.getEdad()));
        assertEquals("ruben 20 años, espadon 6 kg --> la mitad ", 3, armaEspadon1.getPotencia(ruben.getEdad()));
        assertEquals("ruben potencia final", 53, ruben.getPotencia()); //20 + 30 + 3

        Set<Arma> armasS2 = new HashSet<>();
        Espadon armaEspadon2 = new Espadon(10);
        Pistolete armaPistolete2 = new Pistolete(25);

        armasS2.add(armaEspadon2);
        armasS2.add(armaPistolete2);
        Soldado horacio = new Soldado(45, "Horacio", armasS2);

        assertEquals("horacio 20 años, pistolete 25 cm --> el doble", 75, armaPistolete2.getPotencia(horacio.getEdad()));
        assertEquals("horacio 20 años, espadon 10 kg --> la mitad ", 6, armaEspadon2.getPotencia(horacio.getEdad()));
        assertEquals("horacio potencia final", 101, horacio.getPotencia()); //20 + 75 + 6

        Set<Persona> list2 = new HashSet<>();

        list2.add(ruben);
        list2.add(horacio);
        Planeta tierra = new Planeta(list2, 1);
        assertEquals("cant km muralla antes de tributos", 0, tierra.getLongMurallaTotalKM());

        tierra.recibirTributos(); //soldados construyen 5km de muralla

        assertEquals("cant km muralla antes de tributos", 10, tierra.getLongMurallaTotalKM());
    }
}
