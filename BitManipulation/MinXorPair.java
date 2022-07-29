package BitManipulation;

/*
1. You are given an array of distinct integers.
2. You have to print all pairs of integers in the array whose XOR value is minimum.
*/

import java.io.*;
import java.util.*;

public class MinXorPair {

    public static void solution(int[] arr) {
        
        Arrays.sort(arr);
        ArrayList<String> array = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for(int i=0; i<arr.length-1; i++){
            int xor= arr[i] ^ arr[i+1];
            if(xor<min){
                min = xor;
                array = new ArrayList<>();
                array.add(arr[i]+", "+arr[i+1]);
            }else if(xor==min){
                array.add(arr[i]+", "+arr[i+1]);
            }
        }
        
        for(String val: array){
            System.out.println(val);
        }
        
    }
	public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++){
            arr[i] = scn.nextInt();
        }
        solution(arr);
    }
    
    
}