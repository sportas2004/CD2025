package org.example;

/**
 * Contiene operaciones sencillas con cadenas y numeros.
 *
 * @author SergioP
 */
public class TrabajoConCaracteres {

    private static final int LONGITUD_MAXIMA = 120;
    private static final int VALOR_POR_DEFECTO = 42;

    /**
     * Concatena dos cadenas y avisa si el resultado supera la longitud maxima.
     *
     * @param cadena1 primera cadena
     * @param cadena2 segunda cadena
     * @return concatenacion de ambas cadenas, o {@code null} si alguna es nula
     */
    public static String doStuff(String cadena1, String cadena2) {
        if (cadena1 == null || cadena2 == null) {
            return null;
        }

        if (cadena1.trim().isEmpty() || cadena2.trim().isEmpty()) {
            throw new IllegalArgumentException("Las cadenas no pueden estar vacias");
        }

        String concatena = cadena1 + cadena2;
        if (concatena.length() > LONGITUD_MAXIMA) {
            System.out.println("too long: " + concatena);
        }

        return concatena;
    }

    /**
     * Multiplica dos numeros, suma un valor fijo e imprime el resultado.
     *
     * @param numero1 primer numero
     * @param numero2 segundo numero
     */
    public static void calc(int numero1, int numero2) {
        int resultado = numero1 * numero2 + VALOR_POR_DEFECTO;
        System.out.println("resultado = " + resultado);
    }

    /**
     * Mantiene compatibilidad con el nombre anterior del metodo.
     *
     * @param numero1 primer numero
     * @param numero2 segundo numero
     * @deprecated usar {@link #calc(int, int)}
     */
    @Deprecated
    public static void Calc(int numero1, int numero2) {
        calc(numero1, numero2);
    }

    /**
     * Metodo de ejemplo sin uso actual.
     *
     * @return valor fijo
     */
    public Integer unusedMethod() {
        return 1;
    }
}
