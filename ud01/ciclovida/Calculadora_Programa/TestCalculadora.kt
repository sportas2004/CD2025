fun main() {
    val calc = Calculadora()

    assert(calc.sumar(2.0, 3.0) == 5.0)
    assert(calc.restar(5.0, 2.0) == 3.0)
    assert(calc.multiplicar(2.0, 4.0) == 8.0)
    assert(calc.dividir(10.0, 2.0) == 5.0)

    println("✅ Todas as probas pasaron correctamente.")
}