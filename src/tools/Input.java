package tools;


import java.util.Scanner;

public class Input {
    public static String getString(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.println(message);
        return sc.nextLine();
    }

    public static int getInteger(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.println(message);
        while (!sc.hasNextInt()) {
            System.out.println("Error. You have to enter a integer number.");
            sc.next();
        }
        return sc.nextInt();
    }


    public static float getFloat(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.println(message);
        while (!sc.hasNextFloat()) {
            System.out.println("Error. You have to enter a float number.");
            sc.next();
        }
        return sc.nextFloat();
    }

   public static char getChar(String message){
       Scanner sc = new Scanner(System.in);
       System.out.println(message);

        return sc.nextLine().toUpperCase().charAt(0);


   }
}
