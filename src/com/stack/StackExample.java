package com.stack;

import java.util.Stack;

public class StackExample {

    /**
     *  LIFo
     * */
    public void example1(){
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println("pop : " + stack.pop()); // return the last element and remove from the stack
        System.out.println("size : " + stack.size());
        System.out.println("peek : " + stack.peek());// return the last element from the stack
        System.out.println("peek : " + stack.peek());
        System.out.println("peek : " + stack.peek());
        System.out.println("peek : " + stack.peek());
        System.out.println("size : " + stack.size());

    }

    public void example2() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        while (stack.iterator().hasNext()) {
            System.out.println("pop : " + stack.pop());
        }
    }

    public static void main(String[] args) {
        StackExample se = new StackExample();
        se.example2();
    }
}
