package org.example

import java.time.LocalDateTime

class Libro(var nombre: String, var tipo: Int, var editorial: String, var año: Int) {


    var LibroRegistro = mutableListOf<Copia>()
    var autores = mutableMapOf<String, String>()


    fun TieneAutor(A: Autor): Libro {
        var agregamoscadena = A.fechaNacimiento + " " + A.nacionalidad
        autores.put(A.nombre, agregamoscadena)
        return this
    }


    fun TieneCopias(C: Copia): Libro {
        LibroRegistro.add(C)
        return this
    }


    class Copia(var identificador: String, var estado: Boolean) {


        private var keyadd = ""
        private var valueadd = ""
        var Lectores = mutableMapOf<String, String>()




        fun LectoCogeLibro(L: LectorConLibro): Copia {
            keyadd += L.nombre + " "
            valueadd += L.apellidos + " " + L.numsocio + " " + L.direccion
            return this
        }


        fun Prestamos(P: Libro.Copia.Prestamo): Copia {
            Lectores.put(keyadd + P.fechaInicio+" ", valueadd +" "+ P.Fin)
            return this
        }


        class Prestamo(var fechaInicio: LocalDateTime, var Fin: LocalDateTime?) {


            var MultaFechaTardia: Boolean = false
                get() = field
                set(value) = run {
                    field = value
                }


            var devuelveFechaReal: LocalDateTime? = null
                get() = field
                set(porpantalla) = run {
                    field = porpantalla
                }


            fun multa(): Prestamo {
                if (this.fechaInicio.plusDays(15) <= devuelveFechaReal) {
                    this.MultaFechaTardia = true
                    println("Fecha revasada")
                    println("...MULTA...")
                }
                return this
            }
        }


    }
}
