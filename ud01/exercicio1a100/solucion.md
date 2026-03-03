# Lenguaje C
***C*** es un lenguaje compilado.       
Comenzaramos escribiendo el programa de ***c***, en el terminator, comando **nano exercicio.c** se nos abrira el nano en el terminator, aqui pondremos nuestro codigo de ***c***, como se puede ver aqui:  

>#include <stdio.h>  
>int main(){  
>  int i;  
>  for (i=1;i<=100;i+1){  
>      printf("%d ", i);  
>    }  
>}  

A continuacion *guardamos* y salimos del nano, transcribimos el archivo **gcc exercicio.c**      
junto **-o exercicio_compilado** este dara salida  ***.exe*** este archivo lo ejecutamos **./exercicio_compilado**  
Dandonos los 100 números.


# Lenguaje Java
***Java*** es un leguaje que puede ser compilado y interpretado.  
Asegurarnos que en el terminator tenemos instalado ***Java*** con **sudo apt install openjdk-17-jdk**.  
Una vez instalado nos <u>aseguraremos de estar en el mismo repositorio</u> donde se encuentra el archivo ***java***.  
De primeras se describiran los pasos para compilado en ***java***.  
En el terminator **javac Exercicio.java**, en nustro caso el cual contiene lo siguiente:

>public class Exercicio {  
>    public static void main(String[] args) {  
>        for (int i = 1; i <= 100; i++) {  
>            System.out.println("Iteración número: " + i);  
>         }  
>    }  
>}

Al colocar el comando mencionado, se creara una archivo **.class**, desde el terminator **java Exercicio**  
<u>En este caso sin el .class</u>  
Se ejecutara el programa de ***Java*** el cual nos dara los 100 números.  

Para el caso de ***java interpretado*** podremos en el terminato **java Exercicio.java** el cual nos dara la misma solución comentada con anterioridad  


# Lenguaje Python
***Python*** es un lenguaje interpretado.  
Nos aseguraremos de tener ***Python3*** instalado en el terminator.  
Escribimos ***Python3***, se nos abrira el interprete aqui pondremos nuestro codigo:  

>for i in range(0, 101):  
>    print(i)

Le daremos a intro, se ejecutara los 100 numeros.