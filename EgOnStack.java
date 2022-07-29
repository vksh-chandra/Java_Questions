import java.io.*;
import java.util.*;


public class EgOnStack {
    public static void main(String[] args) throws IOException {
        Scanner src = new Scanner(System.in);
        int n = src.nextInt();
        int[] array = new int[n];
        Stack<Integer> stack = new Stack<>();
        int k=0;
        for(int i=0;i<n;i++){
            array[i] = src.nextInt();
            if(i>0 && array[i]>array[i-1]){
                ++k;
            }
        }
        for(int i=0; i<=k;i++){
            stack.push(array[i]);
        }
        int[] x = new int[k];
        int a = stack.pop();
        int b = stack.pop();
        int res =a^b;
        int i=0;
        while(!stack.empty()){
            x[i++] = res;
            res = res^stack.pop();
        }
        int max = x[0];
        for(int j=1;j<x.length;j++){
            if(max<x[i]){
                max = x[i];
            }
        }
        System.out.println(max);

        src.close();
    }
}