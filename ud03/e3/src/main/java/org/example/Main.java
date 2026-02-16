package org.example;

import java.time.LocalDate;
import java.time.LocalDateTime;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {

        Conferencia conf = new Conferencia(
                "C01",
                "Sindicato Buses",
                "Santiago de Compostela",
                LocalDate.of(2026, 6, 10),
                LocalDate.of(2026, 6, 12)
        );


        Orador orador1 = new Orador("P01", "Ana López", "ana@uni.es", "Conductor Bus");
        Publico publico1 = new Publico("P02", "Carlos Pérez", "carlos@gmail.com", "Ciga");


        Inscripcion ins1 = new Inscripcion("I01", orador1, conf);
        Inscripcion ins2 = new Inscripcion("I02", publico1, conf);


        ins1.confirmar();
        ins2.confirmar();

        conf.rexistrar(ins1);
        conf.rexistrar(ins2);

        Sesion sesion1 = new Sesion(
                "S01",
                "Conduccion",
                LocalDateTime.of(2026, 6, 10, 10, 0),
                "Sala 1",
                conf
        );

        conf.addSesion(sesion1);


        Autor autor1 = new Autor("A01", "Ana López", "Conductor Bus", "ana@bus.es");
        Autor autor2 = new Autor("A02", "Luis Martínez", "MIT", "luis@mit.edu");


        Articulo art1 = new Articulo(
                "ART01",
                "Juguetes",
                TipoArticulo.LONGO,
                "Evolucion",
                12
        );

        art1.addAutor(autor1);
        art1.addAutor(autor2);

        sesion1.addArticulo(art1);


        Asistencia asis1 = new Asistencia(Rol.ORADOR, ins1, sesion1);
        Asistencia asis2 = new Asistencia(Rol.PUBLICO, ins2, sesion1);

        sesion1.engadirAsistencia(asis1);
        sesion1.engadirAsistencia(asis2);


        asis1.marcarPresente();
        asis2.marcarPresente();

        System.out.println("=== CONFERENCIA ===");
        System.out.println("Nome: " + conf.getNome());
        System.out.println("Lugar: " + conf.getLugar());
        System.out.println("Sesións: " + conf.getSesions().size());
        System.out.println("Inscricións: " + conf.getInscricions().size());

        System.out.println("\n=== SESIÓN ===");
        System.out.println("Título: " + sesion1.getTitulo());
        System.out.println("Artigos presentados: " + sesion1.getArtigos().size());
        System.out.println("Asistentes: " + sesion1.getAsistencias().size());

        System.out.println("\n=== ARTIGO ===");
        System.out.println("Título: " + art1.getTitulo());
        System.out.println("Tipo: " + art1.getTipo());
        System.out.println("Autores:");
        for (Autor a : art1.getAutores()) {
            System.out.println(" - " + a.getNome());
        }

        System.out.println("\n=== ASISTENCIAS ===");
        for (Asistencia a : sesion1.getAsistencias()) {
            System.out.println(
                    a.getInscripcion().getParticipante().getNome() +
                            " -> " + a.getRol() +
                            " | Presente: " + a.isPresente()
            );
        }
    }
}


