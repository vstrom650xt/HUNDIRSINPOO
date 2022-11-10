package logic;

import tools.Input;
import tools.Screen;

import java.util.Scanner;

public class Barco {
    public static int[][] crearBarcos() {
        Scanner sc = new Scanner(System.in);
        int[][] arrBarc = new int[2][3];

        for (int i = 0; i < arrBarc.length; i++) {
            for (int j = 0; j < arrBarc[0].length; j++) {
                arrBarc[0][j] = 1 + i++;
                System.out.println("[*]introduce el numero de barcos de " + i + " vida/s");
                arrBarc[1][j] = sc.nextInt();
                while (arrBarc[1][j] > 5) {
                    System.out.println("no puedes tener mas de 5 barcos!");
                    arrBarc[1][j] = sc.nextInt();

                }
            }

            System.out.println("[*]Estos son tus barcos \n" +
                    "[*]vidas / numero de barcos");
            Screen.show(arrBarc);

        }
        return arrBarc;
    }


    public static String getCoordinate() {
        Scanner sc = new Scanner(System.in);
        String coordinate = "";

       do {
           System.out.println("introdoce una coordenada  ( LETRA NUMERO)");
           coordinate= sc.next().toUpperCase();
           if (!longEnought(coordinate)){
               System.out.println("la coordenada debe estar formada por dos caracteres");
               coordinate= sc.next().toUpperCase();
           }else if (!isLetter(coordinate)){
               System.out.println("la letra debe estar entra la A y la H");
               coordinate= sc.next().toUpperCase();

           }else if (!isNumber(coordinate)){
               System.out.println("el numero  debe estar entre el 1 y el 9");
               coordinate= sc.next().toUpperCase();

           }


       }while (!isLetter(coordinate) && !isNumber(coordinate) && !longEnought(coordinate));


        return coordinate;
    }

    public static boolean isLetter(String coord) {
        int i = 65, end = 72;
        boolean correct = false;
        do {
            if (coord.charAt(0) == (char) i) {
                correct = true;

            }

            i++;
        } while (i <= 72 || correct == false);

        return correct;

    }

    public static boolean isNumber(String coord) {


        int i = 1;
        boolean correct = false;
        do {
            if (coord.charAt(1) == i) {
                correct = true;

            }

            i++;
        } while (i <= 9 || correct == false);

        return correct;


    }


    public static boolean longEnought(String coord) {
        boolean correct = false;

        if (coord.length() == 2) {
            correct = true;

        }

        return correct;
    }


}
