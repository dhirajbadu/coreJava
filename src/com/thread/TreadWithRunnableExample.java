package com.thread;

public class TreadWithRunnableExample implements Runnable{

    @Override
    public void run() {
        System.out.println("welcome to google");
        System.out.println(Thread.currentThread().getName());
    }


    public static void main(String[] args) {
        TreadWithRunnableExample ob1 = new TreadWithRunnableExample();
        TreadWithRunnableExample ob2 = new TreadWithRunnableExample();

        Thread thread1 = new Thread(ob1 , "First");

        thread1.setPriority(Thread.MIN_PRIORITY);

        Thread thread2 = new Thread(ob2 , "Secont");

        thread2.setPriority(Thread.MAX_PRIORITY);

        thread1.start();
        thread2.start();
    }
}
