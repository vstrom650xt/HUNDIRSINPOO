package logic;

import static logic.Barco.*;

public class Jugador {

    public static void putShip(char[][] tablero, int[][] barcosJugador) {
        int coordLett = 0, coordNum = 0, auxVidas = 0, vidas;
        String coord = "";
        char orientation;
        boolean putIt = false;

        //condicional si el barco es mayor que 1 pedir orien sino no jugar con la i
        //juego con el numero de barcos
        for (int i = 0; i < barcosJugador.length; i++) {
            for (int j = 0; j < barcosJugador[i].length; j++) {
                if (i == 1 && j == 0) {
                    auxVidas = barcosJugador[i][j];
                    for (int k = 0; k < auxVidas; k++) {
                        System.out.println("pon el " + (k + 1) + " barco de " + (i) + " vida");
                        coord = getCoordinate();
                        coordLett = Character.getNumericValue(coord.charAt(0));
                        coordNum = Character.getNumericValue(coord.charAt(1));
                        tablero[coordLett][coordNum] = 'B';
                        barcosJugador[i][j]--;
                        tools.Screen.show(tablero);

                    }

                } else if (i == 1 && j == 1) {
                    auxVidas = barcosJugador[i][j];
                    for (int k = 0; k < auxVidas; k++) {
                        do {
                            System.out.println("pon el " + (k + 1) + " barco de " + (barcosJugador[0][1]) + " vidas");
                            coord = getCoordinate();
                            coordLett = Character.getNumericValue(coord.charAt(0));
                            coordNum = Character.getNumericValue(coord.charAt(1));
                            orientation = Barco.getOrientation(barcosJugador);
                            putIt = drawShip(coordLett, coordNum, orientation, tablero, barcosJugador, 2);

                        } while (!putIt);
                        tools.Screen.show(tablero);
                        barcosJugador[i][j]--;
                    }

                } else if (i == 1 && j == 2) {
                    auxVidas = barcosJugador[i][j];
                    for (int k = 0; k < auxVidas; k++) {
                        System.out.println("pon el " + (k + 1) + " barco de " + (barcosJugador[0][2]) + " vidas");
                        coord = getCoordinate();
                        coordLett = Character.getNumericValue(coord.charAt(0));
                        coordNum = Character.getNumericValue(coord.charAt(1));
                        orientation = Barco.getOrientation(barcosJugador);
                        drawShip(coordLett, coordNum, orientation, tablero, barcosJugador, 3);
                        barcosJugador[i][j]--;
                    }

                }
            }

        }


    }


}
