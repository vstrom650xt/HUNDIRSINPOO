package logic;

import tools.Input;
import tools.Screen;

import java.util.Scanner;

/**
 * This is class is used to place the ships on the boards, ask the user for the quantity of ships , the orientation
 * and check if there is any ship around the corner
 */
public class Ship {
    /**
     * this method ask the user  how many ships  he wants to own
     *
     * @return an array of ships  lifes/number of ships
     */
    public static int[][] crearBarcos() {
        Scanner sc = new Scanner(System.in);
        int[][] arrBarc = new int[2][3];

        for (int i = 0; i < arrBarc.length; i++) {
            for (int j = 0; j < arrBarc[0].length; j++) {
                arrBarc[0][j] = 1 + i++;
                //  System.out.println("[*]introduce el numero de barcos de " + i + " vida/s");
                arrBarc[1][j] = Input.getInteger("[*]enter the number of ships of " + i + " life/s you want to own");
                while (arrBarc[1][j] > 4 || arrBarc[1][j] <= 0) {
                    System.out.println("you cant own more than 4 ships or go to the war without them!");
                    arrBarc[1][j] = sc.nextInt();
                }
            }

            System.out.println("[*]this are your ships \n" + "[*]lifes /number of ships");
            Screen.show(arrBarc);

        }
        return arrBarc;
    }


    /**
     * get the orientation to place the ship
      * @param shipsPlayer
     * @return V - VERTICAL or H - HORIZONTAL
     */
    public static char getOrientation(int[][] shipsPlayer) {
        char decision;
        do {

            decision = Input.getChar("elige posicion vertical (V) u horizontal (H)");
            for (int i = 0; i < shipsPlayer.length; i++) {
                for (int j = 0; j < shipsPlayer.length; j++) {
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

    /**
     * method to draw the ship on the board depending on the size
     * @param coordNumb
     * @param coordLett
     * @param orientation
     * @param playerBoard
     * @param barcosJugador
     * @param sizeShip
     * @return
     */
    public static boolean drawShip(int coordNumb, int coordLett, char orientation, char[][] playerBoard, int[][] barcosJugador, int sizeShip) {
        boolean correct = false;
        //juego con las vidas de los barcos
        if (sizeShip == 2) {
            if (orientation == 'V') {
                if (coordNumb + 1 >= 10) {
                } else {
                    playerBoard[coordNumb][coordLett] = 'B';
                    playerBoard[coordNumb + 1][coordLett] = 'B';
                    correct = true;
                }
            } else if (orientation == 'H') {
                if (coordLett + 1 >= 10) {
                } else {
                    playerBoard[coordNumb][coordLett] = 'B';
                    playerBoard[coordNumb][coordLett + 1] = 'B';
                    correct = true;

                }

            }
        } else if (sizeShip == 3) {
            if (orientation == 'V') {
                if (coordNumb + 1 >= 10) {
                } else {
                    playerBoard[coordNumb][coordLett] = 'B';
                    playerBoard[coordNumb + 1][coordLett] = 'B';
                    playerBoard[coordNumb + 2][coordLett] = 'B';
                    correct = true;
                }

            } else if (orientation == 'H') {
                if (coordLett + 1 >= 10) {
                } else {
                    playerBoard[coordNumb][coordLett] = 'B';
                    playerBoard[coordNumb][coordLett + 1] = 'B';
                    playerBoard[coordNumb][coordLett + 2] = 'B';
                    correct = true;

                }

            }

            if (!correct) {
                System.out.println("you´r out of the board");

            }

        }

        return correct;
    }

    /**
     * check around the ships just to make sure they are not placed next to each other 2 and 3 lifes
     *
     * @param coordNumb
     * @param coordLett
     * @param board
     * @param orientation
     * @param size
     * @return
     */
    public static boolean isBigShip(int coordNumb, int coordLett, char[][] board, char orientation, int size) {
        boolean todo = false;

        if (size == 2) {
            todo = twoLives(coordNumb, coordLett, board, orientation, todo);
        } else if (size == 3) {
            todo = threeLives(coordNumb, coordLett, board, orientation, todo);
        }
        return todo;
    }

    /**
     * this method check around ships who have 3 lives
     * @param coordNumb
     * @param coordLett
     * @param board
     * @param orientation
     * @param todo
     * @return true if there is no ships around
     */

    private static boolean threeLives(int coordNumb, int coordLett, char[][] board, char orientation, boolean todo) {
        boolean its3;
        boolean its;
        boolean its2;
        if (orientation == 'V') {
            if (coordNumb + 1 >= 10) {
            } else {
                if (coordNumb == 1 && coordLett == 9) {
                    its = cornTopRight(coordNumb, coordLett, board);
                    its2 = isRight(coordNumb + 1, coordLett, board);
                    its3 = isRight(coordNumb + 2, coordLett, board);
                    if (its || its2 || its3)
                        todo = true;
                } else if (coordNumb == 1 && coordLett == 1) {
                    its = cornTopLeft(coordNumb, coordLett, board);
                    its2 = isLeft(coordNumb + 1, coordLett, board);
                    its3 = isLeft(coordNumb + 2, coordLett, board);

                    if (its || its2 || its3)
                        todo = true;


                } else if (coordNumb == 7 && coordLett == 1) {
                    its = isLeft(coordNumb, coordLett, board);
                    its2 = isLeft(coordNumb + 1, coordLett, board);
                    its3 = cornBotLeft(coordNumb + 2, coordLett, board);

                    if (its || its2 || its3)
                        todo = true;


                } else if (coordNumb == 7 && coordLett == 9) {
                    its = isRight(coordNumb, coordLett, board);
                    its2 = isRight(coordNumb + 1, coordLett, board);
                    its3 = cornBotLeft(coordNumb + 2, coordLett, board);

                    if (its || its2 || its3)
                        todo = true;

                } else if (coordNumb > 7) {

                    todo = true;
                } else if (coordNumb == 7) {

                    its = inCenter(coordNumb, coordLett, board);
                    its2 = inCenter(coordNumb + 1, coordLett, board);
                    its3 = isBot(coordNumb + 2, coordLett, board);

                    if (its || its2 || its3)
                        todo = true;

                } else if (coordLett == 1) {

                    its = isLeft(coordNumb, coordLett, board);
                    its2 = isLeft(coordNumb + 1, coordLett, board);
                    its3 = isLeft(coordNumb + 2, coordLett, board);

                    if (its || its2 || its3)
                        todo = true;


                } else if (coordLett == 9) {
                    its = isRight(coordNumb, coordLett, board);
                    its2 = isRight(coordNumb + 1, coordLett, board);
                    its3 = isRight(coordNumb + 2, coordLett, board);

                    if (its || its2 || its3)
                        todo = true;
                } else if (coordNumb == 1) {
                    its = isTop(coordNumb, coordLett, board);
                    its2 = inCenter(coordNumb + 1, coordLett, board);
                    its3 = inCenter(coordNumb + 2, coordLett, board);
                    if (its || its2 || its3)
                        todo = true;
                } else if (coordNumb > 7) {
                    System.out.println("you are out of the board");
                    todo = true;


                } else {
                    its = inCenter(coordNumb, coordLett, board);
                    its2 = inCenter(coordNumb + 1, coordLett, board);
                    its3 = inCenter(coordNumb + 2, coordLett, board);

                    if (its || its2 || its3)
                        todo = true;
                }

            }
        } else if (orientation == 'H') {
            if (coordLett + 1 >= 10) {
                todo = false;

            } else {
                //esquina arriba derecha
                if (coordNumb == 1 && coordLett >= 7) {
                    todo = true;

                    //esquina abajo derecha
                } else if (coordNumb == 9 && coordLett == 9) {
                    todo = true;

                } else if (coordNumb == 1 && coordLett == 1) {
                    its = cornTopLeft(coordNumb, coordLett, board);
                    its2 = isLeft(coordNumb, coordLett + 1, board);
                    its3 = isLeft(coordNumb, coordLett + 2, board);

                    if (its || its2 || its3)
                        todo = true;

                    //esquina abajo izquierda
                } else if (coordNumb == 9 && coordLett == 1) {
                    its = cornBotLeft(coordNumb, coordLett, board);
                    its2 = isBot(coordNumb, coordLett + 1, board);
                    its3 = isBot(coordNumb, coordLett + 2, board);

                    if (its || its2 || its3)
                        todo = true;
                    //comprobar  arriba
                } else if (coordNumb == 1 && coordLett == 8) {
                    its = isTop(coordNumb, coordLett, board);
                    its2 = cornTopRight(coordNumb, coordLett + 1, board);
                    its3 = cornTopRight(coordNumb, coordLett + 2, board);

                    if (its || its2 || its3)
                        todo = true;
                } else if (coordNumb == 1) {
                    its = isTop(coordNumb, coordLett, board);
                    its2 = isTop(coordNumb, coordLett + 1, board);
                    its3 = isTop(coordNumb, coordLett + 2, board);

                    if (its || its2 || its3)
                        todo = true;
                    //comprobar derecha
                } else if (coordNumb == 9 && coordLett == 7) {
                    its = isBot(coordNumb, coordLett, board);
                    its2 = isBot(coordNumb, coordLett + 1, board);
                    its3 = cornBotLeft(coordNumb, coordLett + 2, board);

                    if (its || its2 || its3)
                        todo = true;
                } else if (coordLett == 8) {
                    todo = true;

                    //comprobar abajo
                } else if (coordLett == 9) {
                    todo = true;

                } else if (coordNumb == 9) {
                    its = isBot(coordNumb, coordLett, board);
                    its2 = isBot(coordNumb, coordLett + 1, board);
                    its3 = isBot(coordNumb, coordLett + 2, board);

                    if (its || its2 || its3)
                        todo = true;
                } else if (coordLett == 7) {

                    its = inCenter(coordNumb, coordLett, board);
                    its2 = inCenter(coordNumb, coordLett + 1, board);
                    its3 = isRight(coordNumb, coordLett + 2, board);

                    if (its || its2 || its3)
                        todo = true;
                } else {
                    its = inCenter(coordNumb, coordLett, board);
                    its2 = inCenter(coordNumb, coordLett + 1, board);
                    its3 = inCenter(coordNumb, coordLett + 2, board);

                    if (its || its2 || its3)
                        todo = true;
                }
            }
        }
        return todo;
    }

    /**
     * method that check around ships who have 2 lifes
     * @param coordNumb
     * @param coordLett
     * @param board
     * @param orientation
     * @param allGood
     * @return true if it can place it
     */
    private static boolean twoLives(int coordNumb, int coordLett, char[][] board, char orientation, boolean allGood) {
        boolean its2;
        boolean its;
        if (orientation == 'V') {
            if (coordNumb + 1 >= 10) {
                allGood = false;

            } else {
                //esquina arriba derecha
                if (coordNumb == 1 && coordLett == 9) {
                    its = cornTopRight(coordNumb, coordLett, board);
                    its2 = isRight(coordNumb + 1, coordLett, board);
                    if (its || its2)
                        allGood = true;
                    //esquina abajo derecha
                } else if (coordNumb == 9 && coordLett == 9) {
                    allGood = false;

                } else if (coordNumb == 1 && coordLett == 1) {
                    its = cornTopLeft(coordNumb, coordLett, board);
                    its2 = isLeft(coordNumb + 1, coordLett, board);
                    if (its || its2)
                        allGood = true;

                    //esquina abajo izquierda
                } else if (coordNumb == 9 && coordLett == 1) {
                    allGood = false;

                    //comprobar  arriba
                } else if (coordNumb == 8 && coordLett == 1) {
                    its = isRight(coordNumb, coordLett, board);
                    its2 = isBot(coordNumb + 1, coordLett, board);
                    if (its || its2)
                        allGood = true;
                } else if (coordNumb == 8 && coordLett == 9) {
                    its = isRight(coordNumb, coordLett, board);
                    its2 = cornBotLeft(coordNumb + 1, coordLett, board);
                    if (its || its2)
                        allGood = true;

                } else if (coordNumb == 1) {
                    its = isTop(coordNumb, coordLett, board);
                    its2 = inCenter(coordNumb + 1, coordLett, board);
                    if (its || its2)
                        allGood = true;
                    //comprobar derecha
                } else if (coordLett == 9) {
                    its = isRight(coordNumb, coordLett, board);
                    its2 = isRight(coordNumb + 1, coordLett, board);
                    if (its || its2)
                        allGood = true;
                    //comprobar abajo
                } else if (coordNumb == 9) {
                    allGood = false;

                    //comrpobar fila 8
                } else if (coordNumb == 8) {
                    its = inCenter(coordNumb, coordLett, board);
                    its2 = isBot(coordNumb + 1, coordLett, board);
                    if (its || its2)
                        allGood = true;
                } else if (coordLett == 1) {
                    its = isLeft(coordNumb, coordLett, board);
                    its2 = isLeft(coordNumb + 1, coordLett, board);
                    if (its || its2)
                        allGood = true;
                    //centro
                } else {
                    its = inCenter(coordNumb, coordLett, board);
                    its2 = inCenter(coordNumb + 1, coordLett, board);
                    if (its || its2)
                        allGood = true;
                }

            }
        } else if (orientation == 'H') {
            if (coordLett + 1 >= 10) {
                allGood = false;

            } else {
                //esquina arriba derecha
                if (coordNumb == 1 && coordLett == 9) {
                    allGood = false;

                    //esquina abajo derecha
                } else if (coordNumb == 9 && coordLett == 9) {
                    allGood = false;

                } else if (coordNumb == 1 && coordLett == 1) {
                    its = cornTopLeft(coordNumb, coordLett, board);
                    its2 = isTop(coordNumb, coordLett + 1, board);
                    if (its || its2)
                        allGood = true;

                    //esquina abajo izquierda
                } else if (coordNumb == 9 && coordLett == 1) {
                    its = cornBotLeft(coordNumb, coordLett, board);
                    its2 = isBot(coordNumb, coordLett + 1, board);
                    if (its || its2)
                        allGood = true;
                    //comprobar  arriba
                } else if (coordNumb == 1 && coordLett == 8) {
                    its = isTop(coordNumb, coordLett, board);
                    its2 = cornTopRight(coordNumb, coordLett + 1, board);
                    if (its || its2)
                        allGood = true;


                } else if (coordNumb == 8 && coordLett == 8) {

                    its = inCenter(coordNumb, coordLett, board);
                    its2 = isRight(coordNumb, coordLett + 1, board);
                    if (its || its2)
                        allGood = true;

                } else if (coordNumb == 9 && coordLett == 8) {
                    its = isBot(coordNumb, coordLett, board);
                    its2 = cornBotLeft(coordNumb, coordLett + 1, board);
                    if (its || its2)
                        allGood = true;
                } else if (coordNumb == 1) {
                    its = isTop(coordNumb, coordLett, board);
                    its2 = isTop(coordNumb, coordLett + 1, board);
                    if (its || its2)
                        allGood = true;
                    //comprobar derecha
                } else if (coordLett == 8) {
                    its = inCenter(coordNumb, coordLett, board);
                    its2 = isRight(coordNumb, coordLett + 1, board);
                    if (its || its2)
                        allGood = true;
                    //comprobar abajo
                } else if (coordLett == 9) {
                    allGood = false;

                    //comrpobar fila 8

                } else if (coordNumb == 9) {
                    its = isBot(coordNumb, coordLett, board);
                    its2 = isBot(coordNumb, coordLett + 1, board);
                    if (its || its2)
                        allGood = true;
                } else {
                    its = inCenter(coordNumb, coordLett, board);
                    its2 = inCenter(coordNumb, coordLett + 1, board);
                    if (its || its2)
                        allGood = true;
                }
            }
        }
        return allGood;
    }

    /**
     * this method check around ships who have 1 life
     * @param coordNumb
     * @param coordLett
     * @param board
     * @return true if there is a ship around the ships who have 1 life
     */
    public static boolean isShip(int coordNumb, int coordLett, char[][] board) {
        boolean its;

        //esquina arriba derecha
        if (coordNumb == 1 && coordLett == 9) {
            its = cornTopRight(coordNumb, coordLett, board);
            //esquina abajo derecha
        } else if (coordNumb == 9 && coordLett == 9) {
            its = cornBotLeft(coordNumb, coordLett, board);
            //esquina arriba izquierda
        } else if (coordNumb == 1 && coordLett == 1) {
            its = cornTopLeft(coordNumb, coordLett, board);
            //esquina abajo izquierda
        } else if (coordNumb == 9 && coordLett == 1) {
            its = cornBotRight(coordNumb, coordLett, board);
            //comprobar  arriba
        } else if (coordNumb == 1) {
            its = isTop(coordNumb, coordLett, board);
            //comprobar derecha
        } else if (coordLett == 9) {
            its = isRight(coordNumb, coordLett, board);
            //comprobar abajo
        } else if (coordNumb == 9) {
            its = isBot(coordNumb, coordLett, board);
            //comrpobar izquierda
        } else if (coordLett == 1) {
            its = isLeft(coordNumb, coordLett, board);
            //centro
        } else {
            its = inCenter(coordNumb, coordLett, board);
        }


        return its;
    }

    /**
     * all this littel method are used to  check if there is any other ship around a ship before place it
     * @param coordNumb
     * @param coordLett
     * @param board
     * @return false if there is no ships around
     */

    public static boolean cornBotRight(int coordNumb, int coordLett, char[][] board) {
        boolean its = false;


        if (board[coordNumb][coordLett] == 'B' || board[coordNumb - 1][coordLett] == 'B' || board[coordNumb][coordLett + 1] == 'B') {
            its = true;
        }

        return its;
    }

    public static boolean cornTopLeft(int coordNumb, int coordLett, char[][] board) {
        boolean its = false;

        if (board[coordNumb][coordLett] == 'B' || board[coordNumb - 1][coordLett] == 'B' || board[coordNumb][coordLett + 1] == 'B') {
            its = true;
        }
        return its;
    }

    public static boolean cornBotLeft(int coordNumb, int coordLett, char[][] board) {
        boolean its = false;

        if (board[coordNumb][coordLett] == 'B' || board[coordNumb - 1][coordLett] == 'B' || board[coordNumb][coordLett - 1] == 'B') {
            its = true;
        }
        return its;
    }

    public static boolean cornTopRight(int coordNumb, int coordLett, char[][] board) {
        boolean its = false;

        if (board[coordNumb][coordLett] == 'B' || board[coordNumb + 1][coordLett] == 'B' || board[coordNumb][coordLett - 1] == 'B') {
            its = true;
        }
        return its;
    }

    public static boolean isTop(int coordNumb, int coordLett, char[][] board) {
        boolean its = false;

        if (board[coordNumb][coordLett] == 'B' || board[coordNumb + 1][coordLett] == 'B' || board[coordNumb][coordLett + 1] == 'B' || board[coordNumb][coordLett - 1] == 'B') {
            its = true;
        }
        return its;
    }

    public static boolean isRight(int coordNumb, int coordLett, char[][] board) {
        boolean its = false;

        if (board[coordNumb][coordLett] == 'B' || board[coordNumb + 1][coordLett] == 'B' || board[coordNumb - 1][coordLett] == 'B' || board[coordNumb][coordLett - 1] == 'B') {
            its = true;
        }
        return its;
    }

    public static boolean isBot(int coordNumb, int coordLett, char[][] board) {
        boolean its = false;

        if (board[coordNumb][coordLett] == 'B' || board[coordNumb - 1][coordLett] == 'B' || board[coordNumb][coordLett - 1] == 'B' || board[coordNumb][coordLett + 1] == 'B') {
            its = true;
        }
        return its;
    }

    public static boolean isLeft(int coordNumb, int coordLett, char[][] board) {
        boolean its = false;
        if (board[coordNumb][coordLett] == 'B' || board[coordNumb + 1][coordLett] == 'B' || board[coordNumb - 1][coordLett] == 'B' || board[coordNumb][coordLett + 1] == 'B') {
            its = true;
        }
        return its;
    }

    //REVISAR
    public static boolean inCenter(int coordNumb, int coordLett, char[][] board) {
        boolean its = false;
        if (board[coordNumb][coordLett] == 'B' || board[coordNumb + 1][coordLett] == 'B' || board[coordNumb - 1][coordLett] == 'B' || board[coordNumb][coordLett + 1] == 'B' || board[coordNumb][coordLett - 1] == 'B') {
            its = true;
        }
        return its;
    }

    /**
     *  method to get a coordinata that we will separte later
     * @return a string with the coordinate
     */
    public static String getCoordinate() {
        Scanner sc = new Scanner(System.in);
        String coordinate;

        do {
            coordinate = sc.next().toUpperCase().trim();
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

    /**
     *  method to translate the letter into a number
     * @param coord
     * @return
     */
    public static int translateCoorLetter(String coord) {
        char aux = (char) ((coord.charAt(1) - 'A') + 1);
        return aux;
    }

    /**
     * method to separate the number
     * @param coord
     * @return the value of the letter translated into integer
     */
    public static int translateCoorNum(String coord) {
        int aux = Character.getNumericValue(coord.charAt(0));
        return aux;
    }

    /**
     * method to know if the coordinate is long enought or too short
     * @param coord
     * @return true if the coordinate is made of a number and a letter
     */
    public static boolean longEnought(String coord) {
        boolean correct = false;
        if (coord.length() == 2) {
            correct = true;

        }

        return correct;
    }

    /**
     * method to know if the letter is between A nd I
     * @param coord
     * @return true if is a correct letter
     */
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

    /**
     *method to know if the number is between 1 and 9
     * @param coord
     * @returnw true if the number is correct
     */
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

    /**
     * method to know if the coordinate is well formatted
     * @param coord
     * @return true if is well formatted
     */
    public static boolean correctFormat(String coord) {
        boolean correct = false;
        if (coord.charAt(0) >= 49 && coord.charAt(0) <= 57 && coord.charAt(1) >= 65 && coord.charAt(1) <= 73)
            correct = true;

        return correct;

    }

    /**
     * method for get the lives
     * @param barcos
     * @return number of lives
     */
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
