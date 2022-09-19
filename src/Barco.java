import tools.Input;
import tools.Screen;

import java.util.Scanner;

public class Barco {

    //   public static int [][] numBarcos = new int[2][];

    public static void ponerBarco() {


    }

    public static int[][] numBars(int[][] numBars) {
        Scanner sc = new Scanner(System.in);

        int[][] arrBarc = new int[1][4];

        for (int i = 0; i < arrBarc.length; i++) {
            for (int j = 0; j < arrBarc[0].length; j++) {
                if (j == 0) {
                    arrBarc[0][j] = 1+i;
                }else {
                    System.out.println("introduce el numero de barcos ");
                    arrBarc[i][j] = sc.nextInt();
                }
                // arrBarc[1][j] = Input.getInteger(sc.next());


            }

            Screen.show(arrBarc);

        }
        return arrBarc;
    }

//    public static void vidaBarcos(){
//        Scanner sc = new Scanner(System.in);
//        for (int i = 0; i < numBarcos.length; i++) {
//            for (int j = 0; j < numBarcos.length; j++) {
//                numBarcos[0][j]= i;
//                System.out.println("introduce el numero de barcos correspondiente al tamañano "+ 1+i);
//                numBarcos[1][j]= Input.getInteger(sc.next());
//
//
//            }
//
//        }
//
//
//
//
//    }
}
