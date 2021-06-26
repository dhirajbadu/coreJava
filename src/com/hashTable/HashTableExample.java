package com.hashTable;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class HashTableExample {

    public static void example1(){

        Map<String , Integer> hm = new HashMap<>();


        hm.put("a" , 1);
        hm.put("b" , 2);
        hm.put("c" , 3);
        hm.put("d" , 4);

        new Thread(){
            @Override
            public void run() {
                hm.put("av" , 1);
                hm.put("bc" , 2);
                hm.put("cc" , 3);
                hm.put("dc" , 4);
                for (Map.Entry m:hm.entrySet()) {
                    System.out.println(hm.containsKey("dc"));
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                /*hm.put("ad" , 1);
                hm.put("bd" , 2);
                hm.put("cd" , 3);
                hm.put("dd" , 4);*/
                hm.remove("dc");
                for (Map.Entry m:hm.entrySet()) {
                    System.out.println(hm.containsKey("dc"));

                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                /*hm.put("ad" , 1);
                hm.put("bd" , 2);
                hm.put("cd" , 3);
                hm.put("dd" , 4);*/
                hm.remove("dc");
                for (Map.Entry m:hm.entrySet()) {
                    System.out.println(hm.containsKey("dc"));
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                /*hm.put("ad" , 1);
                hm.put("bd" , 2);
                hm.put("cd" , 3);
                hm.put("dd" , 4);*/
                hm.remove("dc");
                for (Map.Entry m:hm.entrySet()) {
                    System.out.println(hm.containsKey("dc"));
                }
            }
        }.start();

        System.out.println("size : " +  hm.size());
    }

    public static void example2(){
        Hashtable<String , Integer> ht = new Hashtable<>();

        ht.put("a" , 1);
        ht.put("a" , 1);
        ht.put("b" , 2);
        ht.put("c" , 3);
        ht.put("d" , 4);

        new Thread(){
            @Override
            public void run() {
                for (Map.Entry m:ht.entrySet()) {
                    System.out.println(ht.containsKey("dc"));
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                /*hm.put("ad" , 1);
                hm.put("bd" , 2);
                hm.put("cd" , 3);
                hm.put("dd" , 4);*/
                ht.remove("dc");
                for (Map.Entry m:ht.entrySet()) {
                    System.out.println(ht.containsKey("dc"));

                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                /*hm.put("ad" , 1);
                hm.put("bd" , 2);
                hm.put("cd" , 3);
                hm.put("dd" , 4);*/
                ht.remove("dc");
                for (Map.Entry m:ht.entrySet()) {
                    System.out.println(ht.containsKey("dc"));
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                /*hm.put("ad" , 1);
                hm.put("bd" , 2);
                hm.put("cd" , 3);
                hm.put("dd" , 4);*/
                ht.remove("dc");
                for (Map.Entry m:ht.entrySet()) {
                    System.out.println(ht.containsKey("dc"));
                }
            }
        }.start();

        System.out.println("size : " +  ht.size());
    }

    public static void main(String[] args) {
        // Exception in thread "Thread-0" java.util.ConcurrentModificationException
        for(int i = 0 ; i < 5 ; i++){
            new Thread(){
                @Override
                public void run() {
                    example2();
                }
            }.start();
        }
    }
}
