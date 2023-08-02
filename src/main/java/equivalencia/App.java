package equivalencia;

import java.util.HashSet;
import java.util.Set;

import equivalencia.main.Arma;
import equivalencia.main.Atleta;
import equivalencia.main.Docente;
import equivalencia.main.Espadon;
import equivalencia.main.Persona;
import equivalencia.main.Pistolete;
import equivalencia.main.Planeta;
import equivalencia.main.Soldado;

public class App {
    public static void main(String[] args) {
        Persona julieta = new Persona(42,"Julieta");
        Atleta ana = new Atleta(25,"Ana");    
        Atleta rosa = new Atleta(45,"Rosa",0,8);    
        Atleta perla = new Atleta(28,"Perla",6,4);    
        Docente monica = new Docente(45, "Monica", 6);
        Docente luisa = new Docente(35, "Luisa", 1);
        Set<Persona> list = new HashSet<>();

        list.add(julieta);
        list.add(ana);
        list.add(rosa);
        list.add(perla);
        list.add(monica);        
        list.add(luisa);

        System.out.println("-----TABLA DE VALORES HABITANTES-----");

        for (Persona p : list) {
            System.out.println(p.getNombre() + "--> potencia: " + p.getPotencia() + " inteligencia: " + p.getInteligencia() + (p.esDestacada()?" si":" no") + ". valor: " + p.getValor());
        } 
        

        Planeta triton = new Planeta(list,1);
        System.out.println("\n\n-----DATOS DEL PLANETA-----");
        System.out.print("delegacion diplomatica compuesta por: ");
        triton.getDelegacionDiplomatica().stream().forEach(p->{System.out.print(p.getNombre()+". ");});
        System.out.println("\nvalor inicial de defensa: " + triton.getValorDefensa());
        System.out.println((triton.esCulto() ? "" : "NO") + " es un planeta culto" );
        System.out.println("potencia real: " + triton.getPotenciaReal() +"\n");


        //Perla entrena
        System.out.println("\n-----PERLA ENTRENA-----");
        System.out.println("perla entrena y aprende tecnica. masa actual: " + perla.getMasaMuscular() + " tecnicas actuales: " + perla.getTecnicasConocidas());
        System.out.println("potencia: " + perla.getPotencia() + " inteligencia: " + perla.getInteligencia() + (perla.esDestacada()?" destacada":" no destacada"));
        perla.entrenar(15);
        perla.aprenderTecnica();
        System.out.println("pasaron 15 dias. masa actual: " + perla.getMasaMuscular() + " tecnicas actuales: " + perla.getTecnicasConocidas());
        System.out.println("potencia: " + perla.getPotencia() + " inteligencia: " + perla.getInteligencia() + (perla.esDestacada()?" destacada":" no destacada"));
        perla.aprenderTecnica();
        System.out.println("potencia: " + perla.getPotencia() + " inteligencia: " + perla.getInteligencia() + (perla.esDestacada()?" destacada":" no destacada\n"));


        //Más sobre el planeta
        System.out.println("\n-----MAS SOBRE EL PLANETA-----");
        System.out.println("triton necesita reforzarse: " + (triton.necesitaReforzarse()?"si":"no"));

        System.out.println("cant museos: " + triton.getCantMuseos() + " km de muralla: " + triton.getLongMurallaTotalKM());
        triton.recibirTributos();
        System.out.println("cant museos: " + triton.getCantMuseos() + " km de muralla: " + triton.getLongMurallaTotalKM() +"\n");
 

        //valor de cada persona
        System.out.println("\n-----VALOR DE CADA PERSONA-----");

        System.out.println("cant hab valiosos: " + triton.getHabitantesValiosos().size());
        
        Set<Persona> list2 = new HashSet<>();
        Persona rosana = new Persona(20,"Rosana");
        Atleta claudia = new Atleta(30,"Claudia");    
        list2.add(rosana);
        list2.add(claudia);
        Planeta tierra = new Planeta(list2,0);
        System.out.println("delegacion diplomatica: " + tierra.getDelegacionDiplomatica().size());
        System.out.println("valor inicial de defensa: " + tierra.getValorDefensa());
        System.out.println("es culto: " + (tierra.esCulto() ? "si" : "no"));
        System.out.println("potencia real: " + tierra.getPotenciaReal());
        System.out.println("triton necesita reforzarse: " + (triton.necesitaReforzarse()?"si":"no"+"\n"));


        //apaciguar otro planeta
        System.out.println("\n-----APACIGUAR OTRO PLANETA-----");
        System.out.println("DATOS PLANETA TIERRA\ncant museos: " + tierra.getCantMuseos() + " km de muralla: " + tierra.getLongMurallaTotalKM());
        triton.apaciguarPlaneta(tierra); //triton le da tributo a tierra
        System.out.println("TRITON apacigua TIERRA");
        System.out.println("DATOS PLANETA TIERRA\ncant museos: " + tierra.getCantMuseos() + " km de muralla: " + tierra.getLongMurallaTotalKM()+"\n");

        //soldados
        System.out.println("\n-----SOLDADOS-----");

        Espadon armaEspadon1 = new Espadon(6);
        Espadon armaEspadon2 = new Espadon(10);
        Pistolete armaPistolete1 = new Pistolete(15);
        Pistolete armaPistolete2 = new Pistolete(25);
        Set<Arma> armasS1 = new HashSet<>();
        armasS1.add(armaEspadon1);
        armasS1.add(armaPistolete1);
        Soldado soldado1 = new Soldado(20, "Ruben", armasS1);

        System.out.println("potencia soldado 1 con 20 años, espadon 6 kg y pistolete 15 cm");
        System.out.println("expected pistolete: 30 expected espadon: 3 ");
        System.out.println("20 + 15*2 + 3 = 53 <-- POTENCIA ESPERADA");
        System.out.println("Potencia de soldado1 con armas: " + soldado1.getPotencia()+"\n");

        Set<Arma> armasS2 = new HashSet<>();
        armasS2.add(armaEspadon2);
        armasS2.add(armaPistolete2);
        Soldado soldado2 = new Soldado(45, "Horacio", armasS2);

        System.out.println("potencia soldado 2 con 45 años, espadon 10 kg y pistolete 25 cm");
        System.out.println("expected pistolete: 75 expected espadon: 6 unidades");
        System.out.println("20 + 25*3 + 6 = 101 <-- POTENCIA ESPERADA");
        System.out.println("Potencia de soldado2 con armas: " + soldado2.getPotencia()+"\n");
        list2.add(soldado1); //LIST2 ahora tiene un soldado, a Rosana(Persona) y a Claudia(Atleta) 
        
        tierra = new Planeta(list2, 1);
        System.out.println("DATOS TIERRA. cant museos: " + tierra.getCantMuseos() + " km de muralla: " + tierra.getLongMurallaTotalKM());
        System.out.println("\nTIERRA RECIBE TRIBUTOS DE UN SOLDADO, UNA ATLETA Y UNA PERSONA GENERICA\n");
        tierra.recibirTributos();
        System.out.println("DATOS TIERRA. cant museos: " + tierra.getCantMuseos() + " km de muralla: " + tierra.getLongMurallaTotalKM());
    }

}
