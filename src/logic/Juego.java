package logic;

import tools.Screen;

public class Juego {
    public static char[][] tableroPlayer = Tablero.crearTab();
    public static char[][] tableroEnemy = Tablero.crearTab();
    public static char[][] tableroShootPlayer = Tablero.crearTab();
    public static char[][] TableroShootEnemy = Tablero.crearTab();
    public static int[][] barcosJugador;
    public static int[][] barcosEnemigo;


    public static void main(String[] args) {

        Tablero.verTab(tableroPlayer, tableroEnemy);
        System.out.println();
        Tablero.verTab(tableroShootPlayer, TableroShootEnemy);
        System.out.println();
        barcosJugador = Barco.crearBarcos();
        System.out.println();
        Barco.getCoordinate();
     //   System.out.println(Barco.translateCoor("A"));


    }
}
