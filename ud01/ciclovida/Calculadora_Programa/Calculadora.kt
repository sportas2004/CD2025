class Calculadora {
    fun sumar(a: Double, b: Double): Double = a + b
    fun restar(a: Double, b: Double): Double = a - b
    fun multiplicar(a: Double, b: Double): Double = a * b
    fun dividir(a: Double, b: Double): Double {
        require(b != 0.0) { "Non se pode dividir entre 0." }
        return a / b
    }
}
