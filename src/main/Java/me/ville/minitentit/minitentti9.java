package main.Java.me.ville.minitentit;

import java.util.TimerTask;
import java.util.Timer;

public class minitentti9 {
    interface MediaItem{
        public default String getType(){
            return getClass().toString();
        }
        public default void printInfo(){
        }
    }
    class Book implements MediaItem{
        private String title;
        private int pagecount;

        Book(String title, int pageCount){
            this.title = title;
            this.pagecount = pageCount;
        }
        public void printInfo(){
            System.out.println(title +": " + pagecount + " pages");
        }
        public String getType(){
            return getClass().toString().split(" ")[1];
        }
    }
    class Disc implements MediaItem{
        private String title;
        private int length;
        Disc(String title, int length){
            this.title = title;
            this. length = length;
        }
        public void printInfo(){
            System.out.println(title + ": "+ length +" mins");
        }
        public String getType(){
            return getClass().toString().split(" ")[1];
        }
    }


    class MyTimer extends Timer
    {
        public void runTask(String msg, long timeout)
        {
            schedule(new MyTimerTask(msg), timeout);
        }

        class MyTimerTask extends TimerTask{
            private String msg;
            MyTimerTask(String imsg){
                msg = imsg;
            }
            @Override
            public void run() {
                System.out.println(msg);
            }
        }

    }

}
