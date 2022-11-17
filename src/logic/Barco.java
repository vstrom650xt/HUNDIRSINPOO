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
                while (arrBarc[1][j] > 2) {
                    System.out.println("no puedes tener mas de 2 barcos de cada tipo!");
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
            //  System.out.println("[*]introduce una coordenada  ( LETRA NUMERO)");
            coordinate = sc.next().toUpperCase();

            if (!longEnought(coordinate)) {
                System.out.println("la coordenada debe estar formada por dos caracteres");
                coordinate = sc.next().toUpperCase();
            } else if (!isLetter(coordinate)) {
                System.out.println("la letra debe estar entre la A y la I");
                coordinate = sc.next().toUpperCase();

            } else if (!isNumber(coordinate)) {
                System.out.println("el numero  debe estar entre el 1 y el 9");
                coordinate = sc.next().toUpperCase();

            } else if (!correctFormat(coordinate)) {
                System.out.println("ponga primero la letra y luego el numero");
                coordinate = sc.next().toUpperCase();
            }

        } while (!longEnought(coordinate) || !isLetter(coordinate) || !isNumber(coordinate) || !correctFormat(coordinate));

        coordinate = translateCoorLetter(coordinate) + "" + translateCoorNum(coordinate);
        return coordinate;
    }

    //poner en getCoordinate que pida orienta tambien , qretorne v o h
    public static char getOrientation(int[][] barcosJugador) {
        Scanner sc = new Scanner(System.in);
        char decision = ' ';
        int aux = 0;
        do {
            System.out.println("elige posicion vertical (V) u horizontal (H)");
            decision = sc.next().toUpperCase().charAt(0);
            for (int i = 0; i < barcosJugador.length; i++) {
                for (int j = 0; j < barcosJugador.length; j++) {
                    if (decision == 'V') {
                        decision = 'V';
                    } else if (decision == 'H') {
                        decision = 'H';
                    }
                }
            }

        } while (decision != 'V' && decision != 'H');

        return decision;
    }

    public static void putOnTab(int coordLett, int coordNum, char orientation, char[][] tablero, int[][] barcosJugador, int sizeShip) {

        //juego con las vidas de los barcos
        int aux, twoLives = barcosJugador[0][1], treeLives = barcosJugador[0][2];
        if (sizeShip == 2) {
            if (orientation == 'V') {
                tablero[coordLett][coordNum] = 'B';
                tablero[coordLett + 1][coordNum] = 'B';
            } else {

                tablero[coordLett][coordNum] = 'B';
                tablero[coordLett][coordNum + 1] = 'B';
            }
        } else {
            if (orientation == 'V') {
                tablero[coordLett][coordNum] = 'B';
                tablero[coordLett + 1][coordNum] = 'B';
                tablero[coordLett + 2][coordNum] = 'B';

            } else {

                tablero[coordLett][coordNum] = 'B';
                if (tablero[coordLett][coordNum+1]>tablero.length){
                    System.out.println("te sales del tablero");

                }else {
                    tablero[coordLett][coordNum + 1] = 'B';
                    tablero[coordLett][coordNum + 2] = 'B';
                }



            }

        }

    }
//    public static  boolean outOfMap(){
//
//
//
//    }
//    public static  boolean colisionCheck(){
//
//
//
//    }


    public static int translateCoorLetter(String coord) {
        char aux = (char) ((coord.charAt(0) - 'A') + 1);
        return aux;
    }

    public static int translateCoorNum(String coord) {
        int aux = Character.getNumericValue(coord.charAt(1));
        return aux;
    }

    public static boolean longEnought(String coord) {
        boolean correct = false;
        if (coord.length() == 2) {
            correct = true;

        }

        return correct;
    }

    public static boolean isLetter(String coord) {
        int i = 65;
        boolean correct = false;

        do {
            if (coord.charAt(0) == (char) (i)) {
                correct = true;

            }

            i++;
        } while (i <= 73 && !correct);

        return correct;

    }

    public static boolean isNumber(String coord) {
        int i = 1;
        boolean correct = false;
        int aux = Character.getNumericValue(coord.charAt(1));
        if (aux == 0)
            correct = false;

        do {
            if (aux == i) {
                correct = true;
            }
            i++;
        } while (i <= 9 && !correct);

        return correct;

    }

    public static boolean correctFormat(String coord) {
        boolean correct = false;
        if (coord.charAt(0) >= 65 || coord.charAt(0) <= 73)
            correct = true;

        return correct;

    }


}
