package Stack;

import java.io.*;
import java.util.*;

public class MergeOverlappingInterval {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            arr[j][0] = Integer.parseInt(line.split(" ")[0]);
            arr[j][1] = Integer.parseInt(line.split(" ")[1]);
        }

        mergeOverlappingIntervals(arr);
    }

    static class Pair{
        int s;
        int e;
        Pair(int s, int e){
            this.s = s;
            this.e = e;
        }
    }

    public static void mergeOverlappingIntervals(int[][] intervals) {
        // merge overlapping intervals and print in increasing order of start time
        Stack<Pair> stack = new Stack<>();
        Arrays.sort(intervals, (a,b)-> a[0]-b[0]);
        stack.push(new Pair(intervals[0][0], intervals[0][1]));
        //System.out.println(stack.peek().e);
        
        for(int i=1; i<intervals.length; i++){
            int start = intervals[i][0];
            int end = intervals[i][1];
            //Pair p = 
            if(start<=stack.peek().e){
                Pair rem = stack.pop();
                rem.e = Math.max(rem.e, end);
                stack.push(rem);
            }else{
                stack.push(new Pair(intervals[i][0], intervals[i][1]));
            }
        }
        
        // int i=0;
        // int[][] res = new int[stack.size()][2];
        // while(stack.size()>0){
        //     Pair rem = stack.pop();
        //     res[i][0] = rem.s;
        //     res[i][1] = rem.e;
        //     i++;
        // }
        // return res;
        Collections.reverse(stack);
        while(stack.size()>0){
            Pair rem = stack.pop();
            System.out.println(rem.s+" "+rem.e);
        }
    }

}