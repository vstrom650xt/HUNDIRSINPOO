package logic;

import static logic.Barco.getCoordinate;

public class Jugador {

    public static void putShip(char[][] tablero, int[][] barcosJugador) {
        int coordLett = 0, coordNum = 0;
        String coord = "";
        int aux = 0;
        for (int i = 0; i < barcosJugador.length; i++) {
            for (int j = 0; j < barcosJugador[i].length; j++) {
                if (i == 1) {
                    aux = barcosJugador[i][j];
                    for (int k = 0; k < aux; k++) {
                        System.out.println("pon el  " + (k + 1) + "barco");
                        coord = getCoordinate();
                        coordLett = Character.getNumericValue(coord.charAt(0));
                        coordNum = Character.getNumericValue(coord.charAt(1));
                        tablero[coordLett][coordNum] = 'B';
                        //el problema esta en la orientacion
                        barcosJugador[i][j]--;
                    }
                }
            }

        }


    }


}
