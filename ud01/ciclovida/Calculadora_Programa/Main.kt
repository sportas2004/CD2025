fun main() {
    val calc = Calculadora()

    print("Introduce o primeiro número: ")
    val num1 = readLine()!!.toDouble()

    print("Introduce o segundo número: ")
    val num2 = readLine()!!.toDouble()

    print("Elixe operación (+, -, *, /): ")
    val op = readLine()

    val resultado = when (op) {
        "+" -> calc.sumar(num1, num2)
        "-" -> calc.restar(num1, num2)
        "*" -> calc.multiplicar(num1, num2)
        "/" -> try {
            calc.dividir(num1, num2)
        } catch (e: IllegalArgumentException) {
            println("Erro: ${e.message}")
            return
        }
        else -> {
            println("Operación non válida.")
            return
        }
    }

    println("Resultado: $resultado")

    return main()
}
