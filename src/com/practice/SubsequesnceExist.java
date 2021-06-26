package com.practice;

import java.util.Arrays;
import java.util.List;

public class SubsequesnceExist {

    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        int tempIndex = -1;
        for(int i = 0 ; i < sequence.size() ; i++){
            int cin = array.indexOf(sequence.get(i));
            if(cin < 0){
                return false;
            } else if(cin < tempIndex){
                return false;
            }else{
                tempIndex = cin;
            }
        }
        return true;
        //return sequence.parallelStream().allMatch(s->array.parallelStream().anyMatch(a->a==s));
    }

    public static void main(String[] args) {

        List<Integer> arr = Arrays.asList(5, 1, 22, 25, 6, -1, 8, 10);
        List<Integer> seq = Arrays.asList(4, 5, 1, 22, 25, 6, -1, 8, 10);
        System.out.println(isValidSubsequence( arr, seq));
    }
}
