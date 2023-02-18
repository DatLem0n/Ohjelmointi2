package main.Java.me.ville.minitentit;

public class minitentti3 {
    public static void main(String[] args) {
        System.out.println(convertTime("12:45 AM"));

    }
    static double average(double[] arr) {
        double avrg = 0;
        if(arr.length <= 0){
            return avrg;
        }
        for(int i = 0; i < arr.length; i++){
            avrg = avrg + arr[i];
        }
        avrg = avrg / arr.length;
        return avrg;
    }
    static int getMinimum(int[] arr) {
        int min = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i] < min){
                min = arr[i];
            }
        }
        return min;
    }
    static void printArray(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }
    static boolean checkParenthesis(String s){
        int count = 0;
        char open = '(';
        char close = ')';
        for(int i = 0; i < s.length(); i++) {
            if (count < 0) return false;
            else {
                if (s.charAt(i) == open)    count ++;
                if (s.charAt(i) == close)   count --;
                }
        }
        if(count == 0) return true;
        else return false;
    }
    static String getSubstring(String s){
        return s.split(":")[0];
    }

    static String convertTime(String s){
        int hours;
        int minutes;
        boolean PM;
        hours = Integer.parseInt(s.split(":")[0]);
        minutes = Integer.parseInt(s.split(":")[1].split(" ")[0]);

        if (s.charAt(6) == 'P')      PM = true;
        else PM = false;

        if (PM) {
            hours = hours + 12;
            if (hours == 24) hours = 12;
        }
        if ((!PM) && (hours == 12))
            hours = 0;
        return String.format("%02d:%02d",hours,minutes);
    }
    static boolean isValidTime(String s){
        boolean valid = true;
        int hours;
        int minutes;
        try{
            hours = Integer.parseInt(s.split(":")[0]);
            minutes = Integer.parseInt(s.split(":")[1]);
            if ((hours > 23) || (s.split(":")[0].length() != 2)) valid = false;
            if ((minutes > 59) || (s.split(":")[1].length() != 2)) valid = false;
        }
        catch(Exception e){
            valid = false;
        }

        return valid;
    }
}
