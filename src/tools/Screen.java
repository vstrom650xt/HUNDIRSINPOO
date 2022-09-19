package tools;

public class Screen {
    public static void show(int[] array){
        for (int i=0;i<array.length;i++)
            System.out.print(array[i]+" ");
        System.out.println();
    }
    public static void show(char[] array){
        for (int i=0;i<array.length;i++)
            System.out.print(array[i]+" ");
        System.out.println();
    }
    public static void show(String[] array){
        for (int i=0;i<array.length;i++)
            System.out.print(array[i]+" ");
        System.out.println();
    }
    public static void show(float[] array){
        for (int i=0;i<array.length;i++)
            System.out.print(array[i]+" ");
        System.out.println();
    }
    public static void show(int[][] v){
        for(int row=0;row<v.length;row++) {
            for (int col = 0; col < v[row].length; col++) {
                System.out.print(v[row][col] + " ");
            }
            System.out.println();
        }
    }
    public static void show(String[][] v){
        for(int row=0;row<v.length;row++) {
            for (int col = 0; col < v[row].length; col++) {
                System.out.print(v[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static void show(char[][] v){
        for(int row=0;row<v.length;row++) {
            for (int col = 0; col < v[row].length; col++) {
                System.out.print(v[row][col] + " ");
            }
            System.out.println();
        }
    }
    public static void clear(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}