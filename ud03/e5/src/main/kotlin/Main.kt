package org.example

import java.time.LocalDateTime

fun main() {
    var ElQuijote=Libro("ElQuijote",1,"QUE?",1975)
    var copia1ElQuijote= Libro.Copia("0000",false)
    var Autor1=Autor("Cervantes","Española","10/20/1970")
    var Lector1=LectorConLibro("0010","Paco","Martin Blanco","Calle Arriba")
    var SePrestaCopia0000= Libro.Copia.Prestamo(LocalDateTime.now(), null)
    SePrestaCopia0000.devuelveFechaReal= LocalDateTime.now().plusDays(16)
    SePrestaCopia0000.multa()
    ElQuijote.TieneAutor(Autor1).TieneCopias(copia1ElQuijote)
    copia1ElQuijote.LectoCogeLibro(Lector1).Prestamos(SePrestaCopia0000)
}
