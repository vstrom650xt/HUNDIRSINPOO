package logic;

import tools.Screen;


public class Juego {

    public static char[][] tableroPlayer = Tablero.crearTab();
    public static char[][] tableroEnemy = Tablero.crearTab();
    public static char[][] tableroShootPlayer = Tablero.crearTab();
    public static char[][] tableroShootEnemy = Tablero.crearTab();
    public static int[][] barcosJugador;
    public static int[][] barcosEnemigo;

    public static void comenzar(){

        int vidasJugador =0;
         //int vidasJugador = Barco.totalVidas(barcosJugador);
        //vidasJugador = Barco.totalVidas(barcosJugador)


        Tablero.verTodosTab(tableroPlayer, tableroShootPlayer, tableroEnemy, tableroShootEnemy);
        System.out.println();
        barcosJugador = Barco.crearBarcos();
        vidasJugador = Barco.totalVidas(barcosJugador);
        barcosEnemigo = Pc.copyArry(barcosJugador);
        Jugador.putShip(tableroPlayer, barcosJugador);
        Pc.putPcShip(tableroEnemy, barcosEnemigo);
        System.out.println();
        System.out.println();
        Tablero.verTodosTab(tableroPlayer, tableroShootPlayer, tableroEnemy, tableroShootEnemy);
        System.out.println();
        System.out.println();
        Juego.shoots(vidasJugador,vidasJugador);
    }

    public static void shoots(int vidasJugador, int totalVidasPc) {

        do {
            System.out.println("tu turno");
            Jugador.shootPlayer(tableroShootPlayer,tableroEnemy,totalVidasPc);
            Tablero.verTodosTab(tableroPlayer, tableroShootPlayer, tableroEnemy, tableroShootEnemy);
            System.out.println();
            System.out.println("-------------------------------------------------------------------------------");

            System.out.println();
            Pc.shootPc(tableroShootEnemy,tableroPlayer,vidasJugador);
            Tablero.verTodosTab(tableroPlayer, tableroShootPlayer, tableroEnemy, tableroShootEnemy);

        } while (vidasJugador != 0 && totalVidasPc != 0);


    }
}
