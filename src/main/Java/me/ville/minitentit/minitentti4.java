package main.Java.me.ville.minitentit;

public class minitentti4 {
    public static void main(String[] args) {
        System.out.println(almostEqual(1.2, 1.3, 0.15));
    }
    static boolean almostEqual(double a, double b, double c){
        if (a > b){
            return !(a - b > c);
        }
        else return !(b - a > c);
    }
    static boolean hasEqualColumnWidth(String s){
        String[] rows;
        String[] columns;
        String[] column;
        rows = (s.split("\\n"));
        for (int i = 0; i < rows.length; i++) {
            column = rows[i].split(",");
            for (int j = 0; i < column.length; j++) {
//TÄHÄN sit loppuun toi logiikka ku jaksaa
            }
        }
        return true;
    }

}