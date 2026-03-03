package org.example;

/**
 * Clase en la cual se trabaja tanto con numeros como con caracteres
 *
 * @author SergioP
 */
public class TrabajoConCaracteres {

    /**
     * Metodo el cual concatena cadenas  mira si su longitud es mayor de 120
     * String introducida por usuario
     * @param cadena1
     * String introducida por usuario
     * @param cadena2
     * @return concatena=cadena1+cadena2
     * @throws NullPointerException cuando cadena1 o cadena2 es null
     */

    public static String doStuff(String cadena1, String cadena2) {

        if (cadena1 == null || cadena2 == null) return null;

        try {
            if (cadena1.trim().isEmpty()|| cadena2.trim().isEmpty()) {
                throw new RuntimeException("bad");
            }
        } catch (Exception error) {error.printStackTrace();}

        String concatena = cadena1 + cadena2;
        if (concatena.length() > 120) {System.out.println("too long: " + concatena);}
        return concatena;
    }

    /**
     * Metodo el cual multiplica dos numeros introducidos por el usuario, y le suma un valor por defecto de 42, acabando con una impresion del resultado
     * Varible Int introducida por el usuario
     * @param numero1
     * Variable Int introducida por el usuario
     * @param numero2
     */

    public static void Calc(int numero1, int numero2) {
        int numeroPorDefecto = 42;
        int res = numero1 * numero2 + numeroPorDefecto;
        System.out.println("resultado = " + res);
    }

    /**
     * Metodo que devuelve 1
     * @return 1
     */

    public Integer unusedMethod() {return  1;}
}