package logic;

import static logic.Ship.*;

/**
 * this class let the Pcs hoot anf put ships randomly
 */
public class Pc {
    /**
     * method that copy Players ships into Pc´s ships
     * @param PlayerShips
     * @return
     */
    public static int[][] copyArry(int[][] PlayerShips) {
        int[][] barcosPc = new int[2][3];
        for (int i = 0; i < PlayerShips.length; i++) {
            for (int j = 0; j < PlayerShips[i].length; j++) {
                barcosPc[i][j] = PlayerShips[i][j];

            }

        }


        return barcosPc;
    }

    /**
     * method that return a random orientation
     * @return V OR H
     */

    public static char randOrien() {
        int orient = (int) (Math.random() * (1 + 1) + 0);
        char value;

        if (orient == 1)
            value = 'V';
        else
            value = 'H';


        return value;


    }

    /**
     * method that put the Pc´s ship randomly
     * @param boardPc
     * @param shipsPc
     */
    public static void putPcShip(char[][] boardPc, int[][] shipsPc) {
        int coordLett, coordNum , oneLife = shipsPc[1][0], twoLife = shipsPc[1][1], threeLife = shipsPc[1][2];
        String coord ;
        char orientation;
        boolean putIt;

        for (int k = 0; k < oneLife; k++) {

            do {
                putIt = false;
                coord = randomCoordinate();
                coordNum = Character.getNumericValue(coord.charAt(0));
                coordLett = Character.getNumericValue(coord.charAt(1));
                if (!isShip(coordNum, coordLett, boardPc)) {
                    boardPc[coordNum][coordLett] = 'B';
                    shipsPc[1][0]--;
                    putIt = true;
                }

            } while (!putIt);

        }


        for (int k = 0; k < twoLife; k++) {
            do {
                putIt = false;
                coord = randomCoordinate();
                coordNum = Character.getNumericValue(coord.charAt(0));
                coordLett = Character.getNumericValue(coord.charAt(1));
                orientation = Pc.randOrien();
                if (!isBigShip(coordNum, coordLett, boardPc, orientation, 2)) {
                    putIt = drawShip(coordNum, coordLett, orientation, boardPc, shipsPc, 2);
                }


            } while (!putIt);

        }


        for (int k = 0; k < threeLife; k++) {
            do {
                putIt = false;
                coord = randomCoordinate();
                coordNum = Character.getNumericValue(coord.charAt(0));
                coordLett = Character.getNumericValue(coord.charAt(1));
                orientation = Pc.randOrien();
                if (!isBigShip(coordNum, coordLett, boardPc, orientation, 3)) {
                    putIt = drawShip(coordNum, coordLett, orientation, boardPc, shipsPc, 3);
                }
            } while (!putIt);


        }


    }

    /**
     *
     *  @return a random coordinate between 11 and 99 without 0
     */
    public static String randomCoordinate() {
        String coordinate = "20";
        do {
            while (coordinate.charAt(1) == '0') {
                coordinate = String.valueOf((int) (Math.random() * (99 - 11 + 1) + 11));
            }
        } while (coordinate.charAt(1) == 0);

        return coordinate;
    }


    public static boolean shootPc(char[][] tableroDisparosPc, char[][] tableroJugador, int vidasJugador) {
        String coordShoot;
        int coordNum, coordLett;
        boolean hit = false;

        coordShoot = randomCoordinate();
        coordNum = Character.getNumericValue(coordShoot.charAt(0));
        coordLett = Character.getNumericValue(coordShoot.charAt(1));
        if (tableroJugador[coordNum][coordLett] == 'B') {
            System.out.println("Hit");
            tableroJugador[coordNum][coordLett] = 'X';
            tableroDisparosPc[coordNum][coordLett] = 'X';
            hit = true;
            System.out.println("you got " + vidasJugador + "life/s left");


        } else {
            System.out.println("Water");
            tableroDisparosPc[coordNum][coordLett] = 'A';

        }
        return hit;

    }


}

