package com.sergioportas;

public class Main {
    public static void main() {
        MyScanner ms = new MyScanner("hola a todas\n y hola a todos");
        System.out.println(ms.getPos());
        System.out.println(ms.hasNextLine());

        System.out.println();
        System.out.println(ms.nextLine());
        System.out.println(ms.getPos());
        System.out.println(ms.hasNextLine());

        System.out.println();
        System.out.println(ms.nextLine());
        System.out.println(ms.getPos());
        System.out.println(ms.hasNextLine());

        System.out.println();

        ms = new MyScanner("hola a todas\n y hola a todos\n");
        System.out.println(ms.nextLine());
        System.out.println(ms.nextLine());
        System.out.println(ms.getPos());
        System.out.println(ms.hasNextLine());
        System.out.println();


        ms = new MyScanner("");
        System.out.println(ms.getPos());
        System.out.println(ms.hasNextLine());
    }
}
