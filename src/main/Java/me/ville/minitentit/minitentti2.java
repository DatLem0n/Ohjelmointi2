package main.Java.me.ville.minitentit;

public class minitentti2 {
    public static void main (String [] args) {
        printAsterisk(2);
        System.out.println(bitLen(256));
        System.out.println(test5(5));
        printBox(3, 5);
    }
    static void printAsterisk(int n){
        for(int i = 1; i <= n; i++){
                System.out.print("*");};
    }
    static int bitLen(int n){
        int bits = Integer.toBinaryString(n).length();
        return bits;
    }
    static int test5(int n){
        int x= 0;
        for(int i = 1; i <=n; i++)
        {
            int y = 1;
            for(int j = 1; j <= i; j++)
            {
                y = y*j;
            }
            x += y;
        }
        return x;
    }
    static void printBox(int y, int x){
        for(int i = 1; i <= y; i++){
            for(int j = 1; j <= x; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
