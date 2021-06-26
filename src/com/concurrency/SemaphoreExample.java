package com.concurrency;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {

    public static void main(String[] args) {
        try {
            //Semaphore sema = null;
            Semaphore sema = new Semaphore(1, true);
            Sale sale = new Sale(sema);
            Purchase purchase = new Purchase(sema);

            Thread saleThread = new Thread(sale, "sale");
            Thread purchaseThread = new Thread(purchase, "purchase");

            purchaseThread.start();
            saleThread.start();

        }catch (Exception exc) {
            System.out.println(exc);
        }
    }
}

/**
 * shared resource
 * */
class Status {
    public static void display(String str){
        System.out.println(str);
    }
}

/**
 * decrease the store item count
 * */
class Sale implements Runnable{
    Semaphore sema;

    public Sale(Semaphore sema){
        this.sema = sema;
    }

    @Override
    public void run() {
        System.out.println("Selling item....");
        try {
            if (sema != null) {
                sema.acquire();
                System.out.println("Sale lock acquired");
            }
            for (int i = 0; i < 5; i++) {

                Status.display(Thread.currentThread().getName() + " : " + i);
            }

            if (sema != null) {
                sema.release();
                System.out.println("Sale lock released");
            }
        }catch (InterruptedException exc) {
            System.out.println(exc);
        }
    }
}

/**
 * increase the store item count
 * */
class Purchase implements Runnable{

    Semaphore sema;

    public Purchase(Semaphore sema){
        this.sema = sema;
    }

    @Override
    public void run() {
        System.out.println("Purchasing item....");

        try {
            if (sema != null) {
                sema.acquire();
                System.out.println("Purchasing lock acquired");
            }

            for (int i = 0; i < 10; i++) {
                Status.display(Thread.currentThread().getName() + " : " + i);
            }

            if (sema != null) {
                sema.release();
                System.out.println("Purchasing lock released");
            }
        }catch (InterruptedException exc) {
            System.out.println(exc);
        }
    }
}
