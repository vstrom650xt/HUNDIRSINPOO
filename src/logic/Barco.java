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

    public static boolean drawShip(int coordNumb, int coordLett, char orientation, char[][] tablero, int[][] barcosJugador, int sizeShip) {
        boolean correct = false;
        //juego con las vidas de los barcos
        if (sizeShip == 2) {
            if (orientation == 'V') {
                if (coordNumb + 1 >= 10) {
                    //                System.out.println("te sales del tablero");
                } else {
                    tablero[coordNumb][coordLett] = 'B';
                    tablero[coordNumb + 1][coordLett] = 'B';
                    correct = true;
                }
            } else if (orientation == 'H') {
                if (coordLett + 1 >= 10) {
                    //             System.out.println("te sales del tablero");
                } else {
                    tablero[coordNumb][coordLett] = 'B';
                    tablero[coordNumb][coordLett + 1] = 'B';
                    correct = true;

                }

            }
        } else if (sizeShip == 3) {
            if (orientation == 'V') {
                if (coordNumb + 1 >= 10) {
                    //        System.out.println("te sales del tablero");
                } else {
                    tablero[coordNumb][coordLett] = 'B';
                    tablero[coordNumb + 1][coordLett] = 'B';
                    tablero[coordNumb + 2][coordLett] = 'B';
                    correct = true;
                }

            } else if (orientation == 'H') {
                if (coordLett + 1 >= 10) {
                } else {
                    tablero[coordNumb][coordLett] = 'B';
                    tablero[coordNumb][coordLett + 1] = 'B';
                    tablero[coordNumb][coordLett + 2] = 'B';
                    correct = true;

                }

            }

            if (!correct) {
                System.out.println("te sales del tablero");

            }

        }

        return correct;
    }


    public static boolean isBigShip(int coordNumb, int coordLett, char[][] tablero, char orientation, int size) {
        boolean its = false;
        boolean its2 = false,its3=false;
        boolean todo = false;

        if (size == 2) {
            if (orientation == 'V') {
                if (coordNumb+1 >= 10){
                    System.out.println("te sales del tab");
                }else {
                    //esquina arriba derecha
                    if (coordNumb == 1 && coordLett == 9) {
                        its = cornTopRight(coordNumb, coordLett, tablero);
                        its2 = cornTopRight(coordNumb+1, coordLett, tablero);
                        if (its || its2)
                            todo = true;
                        //esquina abajo derecha
                    }else if (coordNumb == 9 && coordLett == 9){
                        System.out.println("no cabe");
                        todo=false;

                    }else if (coordNumb == 1 && coordLett == 1) {
                        its = cornTopLeft(coordNumb, coordLett, tablero);                        its = cornTopLeft(coordNumb, coordLett, tablero);
                        its = cornTopLeft(coordNumb+1, coordLett, tablero);
                        if (its || its2)
                            todo = true;

                        //esquina abajo izquierda
                    } else if (coordNumb == 9 && coordLett == 1) {
                        System.out.println("no cabe");
                        todo=false;

                        //comprobar  arriba
                    } else if (coordNumb == 1) {
                        its = isTop(coordNumb, coordLett, tablero);
                        its = isTop(coordNumb, coordLett, tablero);

                        //comprobar derecha
                    } else if (coordLett == 9) {
                        its = isRight(coordNumb, coordLett, tablero);
                        its = isRight(coordNumb, coordLett, tablero);

                        //comprobar abajo
                    } else if (coordNumb == 9) {
                        its = isBot(coordNumb, coordLett, tablero);
                        its = isBot(coordNumb, coordLett, tablero);

                        //comrpobar izquierda
                    } else if (coordLett == 1) {
                        its = isLeft(coordNumb, coordLett, tablero);
                        its = isLeft(coordNumb, coordLett, tablero);

                        //centro
                    } else {
                        its = inCenter(coordNumb, coordLett, tablero);
                        its = inCenter(coordNumb, coordLett, tablero);

                    }

//                    its = isBot(coordNumb, coordLett, tablero);
//                    its2 = isTop(coordNumb + 1, coordLett, tablero);
//
//

                }
            } else if (orientation == 'H') {
                if (coordLett+1 >= 10){
                    System.out.println("te sales del tab");
                }else{
                    its = isRight(coordNumb, coordLett, tablero);
                    its2 = isLeft(coordNumb, coordLett + 1, tablero);
                    if (its || its2)
                        todo = true;
                }
            }
        } else if (size == 3) {
             if (orientation == 'V') {
                 if (coordNumb+1 >= 10 && coordNumb+2 >= 10 ){
                     System.out.println("te sales del tab");
                 }else if (coordLett == 1){

                     its = isLeft(coordNumb, coordLett, tablero);
                     its3 =isLeft(coordNumb+1, coordLett, tablero);
                     its2 = isLeft(coordNumb +2, coordLett, tablero);
                     if (its || its2 || its3)
                         todo = true;


                 }else if (coordLett == 9){
                     its = isBot(coordNumb, coordLett, tablero);
                     its3 =inMidV(coordNumb+1, coordLett, tablero);
                     its2 = isTop(coordNumb +2, coordLett, tablero);
                     if (its || its2 || its3)
                         todo = true;
                 }else {
                     its = isBot(coordNumb, coordLett, tablero);
                     its3 =inMidV(coordNumb+1, coordLett, tablero);
                     its2 = isTop(coordNumb +2, coordLett, tablero);
                     if (its || its2 || its3)
                         todo = true;

                 }

            } else if (orientation == 'H') {
                 if (coordLett+1 >=10 && coordLett+2 >=10){
                     System.out.println("te sales del tab");

                 }else {
                     its = isRight(coordNumb, coordLett, tablero);
                     its3=inMidH(coordNumb, coordLett + 1, tablero);
                     its2 = isLeft(coordNumb, coordLett + 2, tablero);
                     if (its || its2|| its3)
                         todo = true;


                 }
            }
        }
        return todo;
    }

    public static boolean isShip(int coordNumb, int coordLett, char[][] tablero) {
        boolean its;

        //esquina arriba derecha
        if (coordNumb == 1 && coordLett == 9) {
            its = cornTopRight(coordNumb, coordLett, tablero);
            //esquina abajo derecha
        } else if (coordNumb == 9 && coordLett == 9) {
            its = cornBotLeft(coordNumb, coordLett, tablero);
            //esquina arriba izquierda
        } else if (coordNumb == 1 && coordLett == 1) {
            its = cornTopLeft(coordNumb, coordLett, tablero);
            //esquina abajo izquierda
        } else if (coordNumb == 9 && coordLett == 1) {
            its = cornBotRight(coordNumb, coordLett, tablero);
            //comprobar  arriba
        } else if (coordNumb == 1) {
            its = isTop(coordNumb, coordLett, tablero);
            //comprobar derecha
        } else if (coordLett == 9) {
            its = isRight(coordNumb, coordLett, tablero);
            //comprobar abajo
        } else if (coordNumb == 9) {
            its = isBot(coordNumb, coordLett, tablero);
            //comrpobar izquierda
        } else if (coordLett == 1) {
            its = isLeft(coordNumb, coordLett, tablero);
            //centro
        } else {
            its = inCenter(coordNumb, coordLett, tablero);
        }


        return its;
    }















    public static boolean inMidV(int coordNumb, int coordLett, char[][] tablero) {
        boolean its = false;

            if (tablero[coordNumb][coordLett] == 'B' || tablero[coordNumb][coordLett + 1] == 'B' || tablero[coordNumb][coordLett - 1] == 'B') {
                System.out.println("ya hay un barco o hay uno muy cerca");
                its = true;

            return its;

        }
        return its;
    }

    public static boolean inMidH(int coordNumb, int coordLett, char[][] tablero) {
        boolean its = false;

            if (tablero[coordNumb][coordLett] == 'B' || tablero[coordNumb+1][coordLett ] == 'B' || tablero[coordNumb-1][coordLett] == 'B') {
                System.out.println("ya hay un barco o hay uno muy cerca");
                its = true;

            return its;

        }
        return its;
    }




    public static boolean cornBotRight(int coordNumb, int coordLett, char[][] tablero) {
        boolean its = false;

        if (tablero[coordNumb][coordLett] == 'B' || tablero[coordNumb - 1][coordLett] == 'B' || tablero[coordNumb][coordLett + 1] == 'B') {
            System.out.println("ya hay un barco o hay uno muy cerca");
            its = true;
        }
        return its;
    }

    public static boolean cornTopLeft(int coordNumb, int coordLett, char[][] tablero) {
        boolean its = false;

        if (tablero[coordNumb][coordLett] == 'B' || tablero[coordNumb - 1][coordLett] == 'B' || tablero[coordNumb][coordLett + 1] == 'B') {
            System.out.println("ya hay un barco o hay uno muy cerca");
            its = true;
        }
        return its;
    }

    public static boolean cornBotLeft(int coordNumb, int coordLett, char[][] tablero) {
        boolean its = false;

        if (tablero[coordNumb][coordLett] == 'B' || tablero[coordNumb - 1][coordLett] == 'B' || tablero[coordNumb][coordLett - 1] == 'B') {
            System.out.println("ya hay un barco o hay uno muy cerca");
            its = true;
        }
        return its;
    }

    public static boolean cornTopRight(int coordNumb, int coordLett, char[][] tablero) {
        boolean its = false;

        if (tablero[coordNumb][coordLett] == 'B' || tablero[coordNumb + 1][coordLett] == 'B' || tablero[coordNumb][coordLett - 1] == 'B') {
            System.out.println("ya hay un barco o hay uno muy cerca");
            its = true;
        }
        return its;
    }

    public static boolean isTop(int coordNumb, int coordLett, char[][] tablero) {
        boolean its = false;

        if (tablero[coordNumb][coordLett] == 'B' || tablero[coordNumb + 1][coordLett] == 'B' || tablero[coordNumb][coordLett + 1] == 'B' || tablero[coordNumb][coordLett - 1] == 'B') {
            System.out.println("ya hay un barco o hay uno muy cerca");
            its = true;
        }
        return its;
    }

    public static boolean isRight(int coordNumb, int coordLett, char[][] tablero) {
        boolean its = false;

        if (tablero[coordNumb][coordLett] == 'B' || tablero[coordNumb + 1][coordLett] == 'B' || tablero[coordNumb - 1][coordLett] == 'B' || tablero[coordNumb][coordLett - 1] == 'B') {
            System.out.println("ya hay un barco o hay uno muy cerca");
            its = true;
        }
        return its;
    }

    public static boolean isBot(int coordNumb, int coordLett, char[][] tablero) {
        boolean its = false;

        if (tablero[coordNumb][coordLett] == 'B' || tablero[coordNumb - 1][coordLett] == 'B' || tablero[coordNumb][coordLett - 1] == 'B' || tablero[coordNumb][coordLett + 1] == 'B') {
            System.out.println("ya hay un barco o hay uno muy cerca");
            its = true;
        }
        return its;
    }

    public static boolean isLeft(int coordNumb, int coordLett, char[][] tablero) {
        boolean its = false;
        if (tablero[coordNumb][coordLett] == 'B' || tablero[coordNumb + 1][coordLett] == 'B' || tablero[coordNumb - 1][coordLett] == 'B' || tablero[coordNumb][coordLett + 1] == 'B') {
            System.out.println("ya hay un barco o hay uno muy cerca");
            its = true;
        }
        return its;
    }

    //REVISAR
    public static boolean inCenter(int coordNumb, int coordLett, char[][] tablero) {
        boolean its = false;
        if (tablero[coordNumb][coordLett] == 'B' || tablero[coordNumb + 1][coordLett] == 'B' || tablero[coordNumb - 1][coordLett] == 'B' || tablero[coordNumb][coordLett + 1] == 'B' || tablero[coordNumb][coordLett - 1] == 'B') {
            System.out.println("ya hay un barco o hay uno muy cerca");
            its = true;
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

    public static int totalVidas(int[][] barcos) {
        int total = 0;
        int vidas1 = 1;

        for (int i = 0; i < barcos.length; i++) {
            for (int j = 0; j < barcos[i].length; j++) {
                if (i == 1) {
                    total += barcos[i][j] * vidas1;
                    vidas1++;

                }

            }

        }
        return total;

    }


}
