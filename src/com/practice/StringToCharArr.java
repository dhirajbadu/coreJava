package com.practice;

public class StringToCharArr {

    public static void example1( String str){
        System.out.println("----------example1-----------------");
        display(str.toCharArray());
    }

    public static void example2( String str){
        char[] ch = new char[str.length()];

        for (int i = 0; i < str.length(); i++) {
            ch[i] = str.charAt(i);
        }
        System.out.println("----------example2-----------------");
        display(ch);
    }

    public static void display(char[] ch){
        for (char c : ch) {
            System.out.println(c);
        }
    }

    public static void main(String[] args) {

        example1("HelloGoogle");
        example2("HelloGoogle");
    }
}
