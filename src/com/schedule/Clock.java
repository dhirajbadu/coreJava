package com.schedule;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Clock {

    Timer timer;

    public Clock(int seconds) {
        timer = new Timer();
        timer.schedule(new RemindTask(), seconds * 1000 , seconds * 1000); // schedule the task
    }

    class RemindTask extends TimerTask {
        public void run() {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println(df.format(new Date()));
            //timer.cancel(); //Terminate the timer thread
        }
    }

    public static void main(String args[]) {
        new Clock(1);
    }
}
