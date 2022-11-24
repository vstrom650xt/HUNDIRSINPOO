package logic;

import static logic.Barco.*;

public class Jugador {

    public static void putShip(char[][] tablero, int[][] barcosJugador) {
        int coordLett = 0, coordNum = 0, vidas1 = barcosJugador[1][0], vidas2 = barcosJugador[1][1], vidas3 = barcosJugador[1][2];
        String coord = "";
        char orientation;
        boolean putIt;

        for (int k = 0; k < vidas1; k++) {
            do {
                putIt = false;
                System.out.println("pon el " + (k + 1) + " barco de " + (barcosJugador[0][0]) + " vida");
                coord = getCoordinate();
                coordNum = Character.getNumericValue(coord.charAt(0));
                coordLett = Character.getNumericValue(coord.charAt(1));
                if (!isShip(coordNum, coordLett, tablero)) {
                    tablero[coordNum][coordLett] = 'B';
                    //      barcosJugador[1][0]--;
                    putIt = true;
                }

            } while (!putIt);
            tools.Screen.show(tablero);

        }


        for (int k = 0; k < vidas2; k++) {
            do {
                putIt = false;
                System.out.println("pon el " + (k + 1) + " barco de " + (barcosJugador[0][1]) + " vidas");
                coord = getCoordinate();
                coordNum = Character.getNumericValue(coord.charAt(0));
                coordLett = Character.getNumericValue(coord.charAt(1));
                orientation = Barco.getOrientation(barcosJugador);
                if (!isBigShip(coordNum, coordLett, tablero, orientation,2)) {
                    putIt = drawShip(coordNum, coordLett, orientation, tablero, barcosJugador, 2);

                }
            } while (!putIt);
            tools.Screen.show(tablero);
            //         barcosJugador[1][1]--;
        }


        for (int k = 0; k < vidas3; k++) {
            do {
                putIt = false;
                System.out.println("pon el " + (k + 1) + " barco de " + (barcosJugador[0][2]) + " vidas");
                coord = getCoordinate();
                coordNum = Character.getNumericValue(coord.charAt(0));
                coordLett = Character.getNumericValue(coord.charAt(1));
                orientation = Barco.getOrientation(barcosJugador);
                if (!isBigShip(coordNum, coordLett, tablero, orientation,3)) {

                    putIt = drawShip(coordNum, coordLett, orientation, tablero, barcosJugador, 3);
                }
            } while (!putIt);
            tools.Screen.show(tablero);

            //        barcosJugador[1][2]--;

        }


    }


    public static boolean shootPlayer(char[][] tableroDisparos, char[][] tableroEnemigo, int vidasPc) {
        String coordShoot;
        int coordNum, coordLett;
        boolean acierto = false;
        System.out.println("pon cord disparo");
        coordShoot = getCoordinate();
        coordNum = Character.getNumericValue(coordShoot.charAt(0));
        coordLett = Character.getNumericValue(coordShoot.charAt(1));
        if (tableroEnemigo[coordNum][coordLett] == 'B') {
            System.out.println("tocado");
            tableroEnemigo[coordNum][coordLett] = 'X';
            tableroDisparos[coordNum][coordLett] = 'X';
         //   vidasPc--;
            acierto= true;
            System.out.println("al enemigo le quedan " + vidasPc);

        } else {
            System.out.println("agua");
            tableroDisparos[coordNum][coordLett] = 'A';

        }
        return acierto;
    }

}


