package logic;

import static logic.Ship.*;

/**
 *this class let the player putships and shoot and also get the current user to display his name
 */
public class Player {
    /**
     * methos that ask the user to place the ships on the board
     * @param playerBoard
     * @param playerShip
     */
    public static void putShip(char[][] playerBoard, int[][] playerShip) {
        int coordLett , coordNum , oneLife = playerShip[1][0], twoLife = playerShip[1][1], threeLife = playerShip[1][2];
        String coord ;
        char orientation;
        boolean putIt;

        for (int k = 0; k < oneLife; k++) {
            do {
                putIt = false;
                System.out.println("enter  the " + (k + 1) + " ship of " + (playerShip[0][0]) + " life");
                coord = getCoordinate();
                coordNum = Character.getNumericValue(coord.charAt(0));
                coordLett = Character.getNumericValue(coord.charAt(1));
                if (!isShip(coordNum, coordLett, playerBoard)) {
                    playerBoard[coordNum][coordLett] = 'B';
                    putIt = true;
                } else {
                    System.out.println("the ship doesn't fit in there or there is a ship around");
                }

            } while (!putIt);
            tools.Screen.show(playerBoard);

        }


        for (int k = 0; k < twoLife; k++) {
            do {
                putIt = false;
                System.out.println("enter  the " + (k + 1) + " ship of " + (playerShip[0][1]) + " lifes");
                coord = getCoordinate();
                coordNum = Character.getNumericValue(coord.charAt(0));
                coordLett = Character.getNumericValue(coord.charAt(1));
                orientation = Ship.getOrientation(playerShip);
                if (!isBigShip(coordNum, coordLett, playerBoard, orientation, 2)) {
                    putIt = drawShip(coordNum, coordLett, orientation, playerBoard, playerShip, 2);

                } else {
                    System.out.println("the ship doesn't fit in there or there is a ship around");
                }
            } while (!putIt);
            tools.Screen.show(playerBoard);
        }


        for (int k = 0; k < threeLife; k++) {
            do {
                putIt = false;
                System.out.println("enter  the " + (k + 1) + " ship of " + (playerShip[0][2]) + " lifes");
                coord = getCoordinate();
                coordNum = Character.getNumericValue(coord.charAt(0));
                coordLett = Character.getNumericValue(coord.charAt(1));
                orientation = Ship.getOrientation(playerShip);
                if (!isBigShip(coordNum, coordLett, playerBoard, orientation, 3)) {

                    putIt = drawShip(coordNum, coordLett, orientation, playerBoard, playerShip, 3);
                } else {

                    System.out.println("the ship doesn't fit in there or there is a ship around");

                }
            } while (!putIt);
            tools.Screen.show(playerBoard);


        }


    }

    /**
     * methos that let the player shoot and draw a B or X
     * @param tableroDisparos
     * @param tableroEnemigo
     * @param vidasPc
     * @return
     */
    public static boolean shootPlayer(char[][] tableroDisparos, char[][] tableroEnemigo, int vidasPc) {
        String coordShoot;
        int coordNum, coordLett;
        boolean acierto = false;
        System.out.println("[*]enter the coordinate to shoot :");
        coordShoot = getCoordinate();
        coordNum = Character.getNumericValue(coordShoot.charAt(0));
        coordLett = Character.getNumericValue(coordShoot.charAt(1));
        if (tableroEnemigo[coordNum][coordLett] == 'B') {
            System.out.println("Hit");
            tableroEnemigo[coordNum][coordLett] = 'X';
            tableroDisparos[coordNum][coordLett] = 'X';
            acierto = true;
            System.out.println("The enemy have " + vidasPc + " life/s left");

        } else {
            System.out.println("Water");
            tableroDisparos[coordNum][coordLett] = 'A';

        }
        return acierto;
    }

    public static String getUser() {
        String userName = System.getProperty("user.name");

        return userName;
    }




}


