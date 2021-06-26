package com.queue;

import java.util.LinkedList;
import java.util.Queue;

public class ReverseTheQueue {
/*
* O(n + n-1 + n-2 + n-3) time
* O(n) space
*
* */
    public static Queue<Integer> doReverse(Queue<Integer> q , Queue<Integer> bq , Queue<Integer> result){
        int lastElIndex = q.size() -1;

        if(result == null){
            result = new LinkedList<>();
        }

        if(bq == null){
            bq = new LinkedList<>();
        }


        while(q.iterator().hasNext()){

            System.out.println("here");
            if(lastElIndex != 0){
                bq.add(q.poll());
                lastElIndex = q.size();
            }else{
                result.add(q.poll());
                break ;
            }


            lastElIndex --;
        }


        if(q.size() == 0 && bq.size() == 0){
            return result;
        }

        return doReverse(bq , q, result);
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        Queue<Integer> result = doReverse(q , null , null);

        while(result.iterator().hasNext()){
            System.out.println(result.poll());
        }
    }
}
