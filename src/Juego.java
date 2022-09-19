import tools.Screen;

public class Juego {
    public static char[][] tablero = Tablero.crearTab();

    public static  int [][]barcos1;
    public static void main(String[] args) {

        Tablero.verTab(tablero);
        Barco.numBars(barcos1);



    }
}
