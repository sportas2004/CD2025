# Analise
Requisitos:

- En linux  
- En Kotlin  
- En VSCode    

- Programa que sume,reste,multiplique e divida dous números dados polo usuario a tráves do terminal.  

- Lóxica e presentaciión deben estar en clases separadas.  

# Deseño

Para manter unha boa separación de responsabilidades, deseñouse o programa en dúas clases:  

**Clase Calculadora (lóxica):**  
>Encárgase de realizar as operacións matemáticas.  
>Métodos: sumar, restar, multiplicar, dividir.

**Clase Main (presentación):**

>Encárgase de ler os datos do usuario, mostrar o menú e amosar os resultados.  
>Chama aos métodos da clase Calculadora.

# Implementación
**Calculadora**  
>class Calculadora {  
>    fun sumar(a: Double, b: Double): Double = a + b  
>    fun restar(a: Double, b: Double): Double = a - b  
>    fun multiplicar(a: Double, b: Double): Double = a * b  
>    fun dividir(a: Double, b: Double): Double {  
>        require(b != 0.0) { "Non se pode dividir entre 0." }  
>        return a / b  
>    }  
>}

**Main**  
>fun main() {  
>    val calc = Calculadora()  
>
>   print("Introduce o primeiro número: ")  
>    val num1 = readLine()!!.toDouble()  
>
>    print("Introduce o segundo número: ")  
>    val num2 = readLine()!!.toDouble()  
>
>    print("Elixe operación (+, -, *, /): ")  
>    val op = readLine()  
>
>    val resultado = when (op) {  
>        "+" -> calc.sumar(num1, num2)  
>        "-" -> calc.restar(num1, num2)  
>        "*" -> calc.multiplicar(num1, num2)  
>        "/" -> try {  
>            calc.dividir(num1, num2)  
>       } catch (e: IllegalArgumentException) {  
>            println("Erro: ${e.message}")  
>            return  
>        }  
>        else -> {  
>            println("Operación non válida.")  
>            return  
>        }  
>    }  
>
>    println("Resultado: $resultado")  
>
>    return main()  
>}  

Dende o terminal, estando no directorio do proxecto:  
Compilamos Main.kt e Calculadora.kt nun único .jar  
>***<u>kotlinc Main.kt Calculadora.kt -include-runtime -d Calculadora.jar</u>***  

>***-include-runtime*** → inclúe a librería Kotlin dentro do .jar, para que só necesites Java no outro PC.  
>
>***-d Calculadora.jar*** → define o nome do arquivo xerado.  


# Probas
Para asegurar que a lóxica da calculadora funciona correctamente, realizáronse probas unitarias sobre a   clase Calculadora de forma automática. Estas probas verifican que os métodos sumar, restar, multiplicar e   dividir devolvan o resultado correcto, incluíndo o control de erros (como dividir entre cero).

**CalculadoraTest**

>fun main() {  
>    val calc = Calculadora()  
>
>    assert(calc.sumar(2.0, 3.0) == 5.0)  
>   assert(calc.restar(5.0, 2.0) == 3.0)  
>    assert(calc.multiplicar(2.0, 4.0) == 8.0)  
>    assert(calc.dividir(10.0, 2.0) == 5.0)  
>
>    println("✅ Todas as probas pasaron correctamente.")  
>}  

No terminal, estando no directorio do proxecto:  
>***<u>kotlinc TestCalculadora.kt Calculadora.kt -include-runtime -d Test.jar</u>***  

> -  TestCalculadora.kt → contén o código das probas automáticas.  
>
> - Calculadora.kt → contén a clase que se está probando.  
>
> - -include-runtime → inclúe as librerías de Kotlin dentro do .jar, para que se poida executar directamente.  
>
> - -d Test.jar → define o nome do arquivo .jar xerado.    

Se todas as probas pasan, mostrarase a mensaxe:    
>- Todas as probas pasaron correctamente.  
>- División por cero correctamente detectada  
### Observacións  

>Estas probas permiten garantir que a lóxica da calculadora é correcta, independentemente da interacción co usuario.  
>
>Poden ampliarse facilmente para novas operacións ou casos especiais no futuro.
>
>As probas unitarias son recomendadas antes de xerar o .jar definitivo para enviar ou executar en outros equipos. 


# Instalación
O obxectivo desta sección é que o programa sexa fácil de executar en calquera ordenador, sen necesidade de instalar   Kotlin, configurar librerías adicionais ou modificar o código fonte. Para iso, utilizamos un arquivo .jar executábel, que é o formato estándar de Java/Kotlin para distribuír programas portables.  
Dende o terminal, estando no directorio do proxecto:  
<hr></hr>    
Compilamos Main.kt e Calculadora.kt nun único .jar  

>***<u>kotlinc Main.kt Calculadora.kt -include-runtime -d Calculadora.jar</u>***  
  

>***-include-runtime*** → inclúe a librería Kotlin dentro do .jar, para que só necesites Java no outro PC.  
>
>***-d Calculadora.jar*** → define o nome do arquivo xerado.   

Para facilitar a execución en Linux, creamoa unh script ejecutar.sh:  
 Script para executar a Calculadora Kotlin    
>cd "$(dirname "$0")"  
>java -jar Calculadora.jar  

Dar permisos de execución:     
>***<u>hmod +x ejecutar.sh</u>***  

>O .sh simplifica a execución: non hai que escribir o comando longo java -jar Calculadora.jar cada vez.  
>
>É portable dentro do mesmo sistema: podes mandar o .jar e o .sh xuntos, e calquera usuario con Java poderá executar a calculadora con un só clic.  
>
>Mantense a separación entre lóxica (Calculadora.jar) e presentación (terminal via .sh).    

# Mantemento
Non fai falta.

## Contorno de traballo
Este proxecto foi desenvolvido en Linux, utilizando Kotlin como linguaxe de programación e Visual Studio Code como editor. A continuación descríbese como configurar o entorno necesario para compilar e executar o programa.  
   1. Instalar Kotlin

No terminal:     
>Instalamos Kotlin con <u>apt</u> el terminator:  
>   ***sudo apt install kotlin***


