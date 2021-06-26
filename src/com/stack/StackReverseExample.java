package com.stack;

import java.util.Stack;

public class StackReverseExample {

    /**
     *  LIFo
     * */
    public static Stack<Integer> doReverseWithArr(Stack<Integer> stack){
        int size = stack.size() -1;
        int[] arr = new int[stack.size()];
        while(stack.iterator().hasNext()){
            arr[size] = stack.pop();
            size --;
        }

        for(int i = arr.length-1 ; i>=0 ; i--){
            stack.add(arr[i]);
        }

        return stack;

    }

    public static Stack<Integer> doReverse(Stack<Integer> stack){
        Stack<Integer> result = new Stack<>();
        while(stack.iterator().hasNext()){
            result.add(stack.pop());
        }

        return result;

    }


    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        Stack<Integer> stack1 = new Stack<>();

        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        stack1.push(4);

        while(stack1.iterator().hasNext()){
            System.out.println(stack1.pop());
        }
        System.out.println("-----after-------");
        stack = doReverse(stack);

        while(stack.iterator().hasNext()){
            System.out.println(stack.pop());
        }
    }
}
