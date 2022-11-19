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
                //  System.out.println("[*]introduce el numero de barcos de " + i + " vida/s");
                arrBarc[1][j] = Input.getInteger("[*]introduce el numero de barcos de " + i + " vida/s");
                while (arrBarc[1][j] > 2 || arrBarc[1][j] <= 0) {
                    System.out.println("no puedes tener mas de 2 barcos de cada tipo ni ir sin barcos!");
                    arrBarc[1][j] = sc.nextInt();
                }
            }

            System.out.println("[*]Estos son tus barcos \n" + "[*]vidas / numero de barcos");
            Screen.show(arrBarc);

        }
        return arrBarc;
    }


    //poner en getCoordinate que pida orienta tambien , qretorne v o h
    public static char getOrientation(int[][] barcosJugador) {
        char decision;
        do {

            decision = Input.getChar("elige posicion vertical (V) u horizontal (H)");
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

    public static Boolean drawShip(int coordNumb, int coordLett, char orientation, char[][] tablero, int[][] barcosJugador, int sizeShip) {
        boolean correct = false;
        //juego con las vidas de los barcos
        if (sizeShip == 2) {
            if (orientation == 'V') {
                if (coordNumb + 1 >= 10) {
                    System.out.println("te sales del tablero");
                } else {
                    tablero[coordNumb][coordLett] = 'B';
                    tablero[coordNumb + 1][coordLett] = 'B';
                    correct = true;
                }
            } else if (orientation == 'H') {
                if (coordLett + 1 >= 10) {
                    System.out.println("te sales del tablero");
                } else {
                    tablero[coordNumb][coordLett] = 'B';
                    tablero[coordNumb][coordLett + 1] = 'B';
                    correct = true;

                }

            }
        } else if (sizeShip == 3) {
            if (orientation == 'V') {
                if (coordNumb + 1 >= 10) {
                    System.out.println("te sales del tablero");
                } else {
                    tablero[coordNumb][coordLett] = 'B';
                    tablero[coordNumb + 1][coordLett] = 'B';
                    tablero[coordNumb + 2][coordLett] = 'B';
                    correct = true;
                }

            } else if (orientation == 'H') {
                if (coordLett + 1 >= 10) {
                    System.out.println("te sales del tablero");
                } else {
                    tablero[coordNumb][coordLett] = 'B';
                    tablero[coordNumb][coordLett + 1] = 'B';
                    tablero[coordNumb][coordLett + 2] = 'B';
                    correct = true;

                }

            }

        }
        return correct;

    }


    public static boolean isBigShip(int coordNumb, int coordLett, char[][] tablero, int size, char orientation) {
        boolean its = false;
        if (size == 2) {

            if (orientation == 'V' && coordLett == 1) {

                //posicion actual                    //1 alante                                    2 alante                                                  1derecha                                                       1izquieda            1alante 1derecha                                1alante 1izquierda                  2alante 1 izquieda                              2alante 1derecha
                if (tablero[coordLett][coordNumb] == 'B' || tablero[coordLett + 1][coordNumb] == 'B' || tablero[coordLett + 2][coordNumb] == 'B' || tablero[coordLett][coordNumb + 1] == 'B' || tablero[coordLett][coordNumb - 1] == 'B' || tablero[coordLett + 1][coordNumb + 1] == 'B' || tablero[coordLett + 1][coordNumb - 1] == 'B' || tablero[coordLett + 2][coordNumb - 1] == 'B' || tablero[coordLett + 2][coordNumb + 1] == 'B') {
                    System.out.println("ya hay un barco");

                    its = true;
                }

                //esto para la  B del mapa y el borde
            } else if (orientation == 'V' && coordLett > 1) {

                //posicion actual                    //1 alante                                    2 alante                                             1 atras               1derecha                                                       1izquieda            1alante 1derecha                                1alante 1izquierda                  2alante 1 izquieda                              2alante 1derecha
                if (tablero[coordLett][coordNumb] == 'B' || tablero[coordLett + 1][coordNumb] == 'B' || tablero[coordLett + 2][coordNumb] == 'B' || tablero[coordLett - 1][coordNumb] == 'B' || tablero[coordLett][coordNumb + 1] == 'B' || tablero[coordLett][coordNumb - 1] == 'B' || tablero[coordLett + 1][coordNumb + 1] == 'B' || tablero[coordLett + 1][coordNumb - 1] == 'B' || tablero[coordLett + 2][coordNumb - 1] == 'B' || tablero[coordLett + 2][coordNumb + 1] == 'B') {
                    System.out.println("ya hay un barco");

                    its = true;
                }
            } else if (orientation == 'H' && coordLett == 1) {
                if (tablero[coordLett][coordNumb] == 'B' || tablero[coordLett][coordNumb + 1] == 'B') {
                    System.out.println("ya hay un barco");

                    its = true;
                }

            }

        } else if (size == 3) {
            if (orientation == 'V') {
                if (tablero[coordLett][coordNumb] == 'B' || tablero[coordLett + 1][coordNumb] == 'B' || tablero[coordLett + 2][coordNumb] == 'B') {
                    System.out.println("ya hay un barco");

                    its = true;
                }
            } else if (orientation == 'H') {
                if (tablero[coordLett][coordNumb] == 'B' || tablero[coordLett][coordNumb + 1] == 'B' || tablero[coordLett][coordNumb + 2] == 'B') {
                    System.out.println("ya hay un barco");

                    its = true;
                }

            }

        }
        return !its;
    }

    public static boolean isShip(int coordNumb, int coordLett, char[][] tablero) {
        boolean its = false;
        //comprobar fila de arriba B
        if (coordNumb == 1 && coordLett !=9) {
            if (tablero[coordNumb][coordLett] == 'B' || tablero[coordNumb + 1][coordLett] == 'B' || tablero[coordNumb][coordLett + 1] == 'B' || tablero[coordNumb][coordLett - 1] == 'B') {
                System.out.println("ya hay un barco");
                its = true;
            }

            //fila arriba y parte derecha
        } else if (coordNumb==1 && coordLett ==9) {
            if (tablero[coordNumb][coordLett] == 'B' || tablero[coordNumb + 1][coordLett] == 'B' ||  tablero[coordNumb][coordLett - 1] == 'B') {
                System.out.println("ya hay un barco");
                its = true;
            }

            //fila abajo izquierda
        } else if (coordNumb==9 &&coordLett == 9) {

            if (tablero[coordLett][coordNumb] == 'B' || tablero[coordLett - 1][coordNumb] == 'B' ||  tablero[coordLett][coordNumb - 1] == 'B') {
                System.out.println("ya hay un barco");
                its = true;
            }

        } else {
            if (tablero[coordLett][coordNumb] == 'B' || tablero[coordLett + 1][coordNumb] == 'B' || tablero[coordLett - 1][coordNumb] == 'B' || tablero[coordLett][coordNumb + 1] == 'B' || tablero[coordLett][coordNumb - 1] == 'B') {
                System.out.println("ya hay un barco");
                its = true;
            }
        }


        return its;
    }

    public static String getCoordinate() {
        Scanner sc = new Scanner(System.in);
        String coordinate;

        do {
            coordinate = sc.next().toUpperCase();
            if (!longEnought(coordinate)) {
                System.out.println("la coordenada debe estar formada por dos caracteres");
            } else if (!correctFormat(coordinate)) {
                System.out.println("ponga primero el numero y luego la letra");
            } else if (!isLetter(coordinate)) {
                System.out.println("la letra debe estar entre la A y la I");
            } else if (!isNumber(coordinate)) {
                System.out.println("el numero  debe estar entre el 1 y el 9");
            }

        } while (!longEnought(coordinate) || !isLetter(coordinate) || !isNumber(coordinate) || !correctFormat(coordinate));
        coordinate = translateCoorNum(coordinate) + "" + translateCoorLetter(coordinate);
        return coordinate;
    }

    public static int translateCoorLetter(String coord) {
        char aux = (char) ((coord.charAt(1) - 'A') + 1);
        return aux;
    }

    public static int translateCoorNum(String coord) {
        int aux = Character.getNumericValue(coord.charAt(0));
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
            if (coord.charAt(1) == (char) (i)) {
                correct = true;

            }

            i++;
        } while (i <= 73 && !correct);

        return correct;

    }

    public static boolean isNumber(String coord) {
        int i = 1;
        boolean correct = false;
        int aux = Character.getNumericValue(coord.charAt(0));
        if (aux == 0) correct = false;

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
        if (coord.charAt(0) >= 49 && coord.charAt(0) <= 57 && coord.charAt(1) >= 65 && coord.charAt(1) <= 73)
            correct = true;

        return correct;

    }


}
