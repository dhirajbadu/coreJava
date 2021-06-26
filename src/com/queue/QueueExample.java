package com.queue;

import com.stack.StackExample;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class QueueExample {

    /**
     * FIFO
     * */
    public void example1(){
        Queue<Integer> q = new LinkedList<>();

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);


        /**
         * Retrieves, but does not remove, the head of this queue.  This method
         * differs from {@link #peek peek} only in that it throws an exception
         * if this queue is empty.
         */
        System.out.println("element : " + q.element());
        System.out.println("size : " + q.size());

        /**
         * Retrieves, but does not remove, the head of this queue,
         * or returns {@code null} if this queue is empty.
         */
        System.out.println("peek : " + q.peek());
        System.out.println("size : " + q.size());

        /**
         * Retrieves and removes the head of this queue,
         * or returns {@code null} if this queue is empty.
         */
        System.out.println("poll : " + q.poll());
        System.out.println("size : " + q.size());

        System.out.println("remove : " + q.remove());
        System.out.println("size : " + q.size());


    }


    public void example2(){
        Queue<Integer> q = new LinkedList<>();

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);

        while(q.iterator().hasNext()){
            System.out.println("poll : " + q.poll());
        }
    }

    public static void main(String[] args) {
        QueueExample qe = new QueueExample();
        qe.example2();
    }
}
