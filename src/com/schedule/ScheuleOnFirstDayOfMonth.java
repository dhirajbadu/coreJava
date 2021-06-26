package com.schedule;

import java.text.SimpleDateFormat;
import java.util.*;

public class ScheuleOnFirstDayOfMonth {
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Timer timer;
    public ScheuleOnFirstDayOfMonth(){
        timer = new Timer();
        Calendar toDay = Calendar.getInstance();
        Calendar nextRun = Calendar.getInstance();
        nextRun.add(Calendar.MONTH, 1);
        nextRun.set(Calendar.DAY_OF_MONTH, 1);

        System.out.println(nextRun.getTimeInMillis() -  toDay.getTimeInMillis());
        System.out.println(nextRun.getTimeInMillis());
        timer.schedule(new DoTask(), nextRun.getTimeInMillis() -  toDay.getTimeInMillis(), nextRun.getTimeInMillis());

    }

    class DoTask extends TimerTask{
        @Override
        public void run() {
            System.out.println(df.format(new Date()));

            Timer timerNext = new Timer();
            Calendar toDay = Calendar.getInstance();
            Calendar nextRun = Calendar.getInstance();
            nextRun.add(Calendar.MONTH, 1);
            nextRun.set(Calendar.DAY_OF_MONTH, 1);

            timerNext.schedule(new DoTask(), nextRun.getTimeInMillis() -  toDay.getTimeInMillis(), nextRun.getTimeInMillis());

            timer.cancel();

        }
    }

    public static void main(String[] args) {
        ScheuleOnFirstDayOfMonth schedule = new ScheuleOnFirstDayOfMonth();
    }
}
