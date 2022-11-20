package logic;

public class Tablero {

    public static void verTodosTab(char[][] tablero, char[][] tableroDisparos,char[][] tableroEnemy,char[][] tableroDisparoEnemy) {
        System.out.println("tablero Enemigo \t\t\ttablero disparos enemigo");
        verTab(tableroEnemy,tableroDisparoEnemy);
        System.out.println();
        System.out.println("tablero \t\t\t\t\ttablero disparos");
        verTab(tablero,tableroDisparos);


    }

    public static void verTab(char[][] tablero, char[][] tableroEnemy) {

        for (int i = 0; i < tablero[0].length; i++) {
            System.out.println();

            for (int j = 0; j < tablero[0].length; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.print("\t\t");
            for (int j = 0; j < tableroEnemy[0].length; j++) {
                System.out.print(tableroEnemy[i][j] + " ");

            }

        }
        System.out.println();

    }


    public static char[][] crearTab() {
        char[][] tablero = new char[10][10];

        char A = (char) 65; //letra A
        char nums = (char) 48; // numeros
        char C = (char) 126; //~~~~

        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                if (j == 0) {
                    tablero[i][0] = nums;
                    nums++;
                } else if (i == 0) {
                    tablero[0][j] = A;
                    A++;
                } else {
                    tablero[i][j] = C;
                }
            }
        }
        return tablero;
    }


}
