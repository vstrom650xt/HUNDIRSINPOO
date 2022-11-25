package logic;

/**
 * this class is used to create and view boards
 */
public class Board {
    /**
     *method to view all boards
     *
     * @param playerBoard
     * @param PlayerShotsBoard
     * @param pcBoard
     * @param PcboardShoots
     */
    public static void viewBoards(char[][] playerBoard, char[][] PlayerShotsBoard, char[][] pcBoard, char[][] PcboardShoots) {
        System.out.println("Enemy Board \t\t\t\tEnemy shooting board");
        viewBoard(pcBoard,PcboardShoots);
        System.out.println();
        System.out.println("board \t\t\t\t\t\tshooting board");
        viewBoard(playerBoard,PlayerShotsBoard);


    }

    /**
     *method to view 2 boards
     *
     * @param playerBoard
     * @param pcBoard
     */
    public static void viewBoard(char[][] playerBoard, char[][] pcBoard) {

        for (int i = 0; i < playerBoard[0].length; i++) {
            System.out.println();

            for (int j = 0; j < playerBoard[0].length; j++) {
                System.out.print(playerBoard[i][j] + " ");
            }
            System.out.print("\t\t");
            for (int j = 0; j < pcBoard[0].length; j++) {
                System.out.print(pcBoard[i][j] + " ");

            }

        }
        System.out.println();

    }

    /**
     * this function return a board totally ready
     *
     * @return a board ready to use
     */
    public static char[][] createBoard() {
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
