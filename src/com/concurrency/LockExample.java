package com.concurrency;

import java.util.concurrent.locks.ReentrantLock;

public class LockExample {

    public static void main(String[] args) {

        try {
           // ReentrantLock lock = null;
           ReentrantLock lock = new ReentrantLock();

            Operation op1 = new Operation(lock, "Work");
            Operation op2 = new Operation(lock, "Play");

            Thread th1 = new Thread(op1);
            Thread th2 = new Thread(op2);

            th1.start();
            th2.start();
        }catch (Exception ex){

        }

    }
}

class Operation implements Runnable{
    String name;
    ReentrantLock lock;
    public Operation(ReentrantLock lock , String name){
        this.name = name;
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            if (lock != null) {
                lock.lock();
            }
            for (int i = 0; i < 5; i++) {
                Thread.sleep(10);
                System.out.println(name);
            }
            if (lock != null) {
                lock.unlock();
            }
        }catch(Exception ex){

        }
    }
}
