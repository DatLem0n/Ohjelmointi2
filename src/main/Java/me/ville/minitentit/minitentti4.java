package main.Java.me.ville.minitentit;

public class minitentti4 {
    public static void main(String[] args) {
        System.out.println(almostEqual(1.2, 1.3, 0.15));
        System.out.println(hasEqualColumnWidth("1,2 \n 3,4"));
        System.out.println(factorial(5));
        System.out.println(numOfCols("10,32456,2234"));
    }
    static boolean almostEqual(double a, double b, double c){
        if (a > b){
            return !(a - b > c);
        }
        else return !(b - a > c);
    }
    static boolean hasEqualColumnWidth(String s){
        String[] rows;
        String[] column;
        int columnlength = 0;
        boolean equals = true;
        rows = (s.split(System.lineSeparator()));
        for (int i = 0; i < rows.length; i++) {
            column = rows[i].split(",");
            if(columnlength == 0) columnlength = column.length;
            else {
                if (columnlength != column.length) equals = false;
            }
        }
        return equals;
    }
    static int factorial(int n){
        int result = 1;
        for (int i = 1; i<=n; i++){
            result = result*i;
        }
        return result;
    }
    static int numOfCols(String s){
        int colAmount;
        colAmount = s.split(",").length;
        if (s.endsWith(",")) colAmount ++;
        return colAmount;
    }
}