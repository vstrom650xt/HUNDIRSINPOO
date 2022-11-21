package logic;

import static logic.Barco.*;

public class Pc {

    public static int[][] copyArry(int[][] barcosJugador) {
        int[][] barcosPc = new int[2][3];
        for (int i = 0; i < barcosJugador.length; i++) {
            for (int j = 0; j < barcosJugador[i].length; j++) {
                barcosPc[i][j] = barcosJugador[i][j];

            }

        }


        return barcosPc;
    }


    public static char randOrien() {
        int orient = (int) (Math.random() * (1 + 1) + 0);
        char value;

        if (orient == 1)
            value = 'V';
        else
            value = 'H';


        return value;


    }

    public static void putPcShip(char[][] tableroPc, int[][] barcosPC) {
        int coordLett = 0, coordNum = 0, vidas1 = barcosPC[1][0], vidas2 = barcosPC[1][1], vidas3 = barcosPC[1][2];
        String coord = "";
        char orientation;
        boolean putIt;

        for (int k = 0; k < vidas1; k++) {

            do {
                putIt = false;
                coord = randomCoordinate();
                coordNum = Character.getNumericValue(coord.charAt(0));
                coordLett = Character.getNumericValue(coord.charAt(1));
                     System.out.println(coordNum + "" + coordLett);
                if (!isShip(coordNum, coordLett, tableroPc)) {
                    tableroPc[coordNum][coordLett] = 'B';
                    barcosPC[1][0]--;
                    putIt = true;
                }

            } while (!putIt);
            //  tools.Screen.show(tableroPc);

        }


        for (int k = 0; k < vidas2; k++) {
            do {
                putIt = false;
                coord = randomCoordinate();
                coordNum = Character.getNumericValue(coord.charAt(0));
                coordLett = Character.getNumericValue(coord.charAt(1));
                orientation = Pc.randOrien();
                System.out.println(coordNum+" "+coordLett );
                if (!isBigShip(coordNum, coordLett, tableroPc, orientation,2)) {
                    putIt = drawShip(coordNum, coordLett, orientation, tableroPc, barcosPC, 2);
                }


            } while (!putIt);
            tools.Screen.show(tableroPc);
            //         tools.Screen.show(tableroPc);

            //   barcosPC[1][1]--;
        }


        for (int k = 0; k < vidas3; k++) {
            do {
                putIt = false;
                coord = randomCoordinate();
                coordNum = Character.getNumericValue(coord.charAt(0));
                coordLett = Character.getNumericValue(coord.charAt(1));
                orientation = Pc.randOrien();
                System.out.println(coordNum+" "+coordLett );
                if (!isBigShip(coordNum, coordLett, tableroPc, orientation,3)) {
                    putIt =drawShip(coordNum, coordLett, orientation, tableroPc, barcosPC, 3);
                }
            } while (!putIt);
            tools.Screen.show(tableroPc);

         //   barcosPC[1][2]--;

        }


    }


    public static String randomCoordinate() {
        String coordinate = "20";
        do {
            //      coordinate = String.valueOf((int) (Math.random() * (99 - 11 + 1) + 11));
            while (coordinate.charAt(1) == '0') {
                coordinate = String.valueOf((int) (Math.random() * (99 - 11 + 1) + 11));
            }
        } while (coordinate.charAt(1) == 0);

        return coordinate;
    }


    public static void shootPc(char[][] tableroDisparosPc, char[][] tableroJugador, int vidasJugador) {
        String coordShoot;
        int coordNum, coordLett;

        coordShoot = randomCoordinate();
        coordNum = Character.getNumericValue(coordShoot.charAt(0));
        coordLett = Character.getNumericValue(coordShoot.charAt(1));
        if (tableroJugador[coordNum][coordLett] == 'B') {
            System.out.println("tocado");
            tableroJugador[coordNum][coordLett] = 'X';
            tableroDisparosPc[coordNum][coordLett] = 'X';
            vidasJugador--;
            System.out.println("te quedan " + vidasJugador);


        } else {
            System.out.println("agua");
        }


    }


}

