package com.thread;

public class ThreadExample {

    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run() {
                System.out.println("Hello Google");
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                System.out.println("Hi Google");
            }
        }.start();
    }
}
