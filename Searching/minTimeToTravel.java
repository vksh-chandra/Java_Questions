package Searching;

import java.util.*;

public class minTimeToTravel {
    public static long minimumTime(int[] time, int totalTrips) {
        Arrays.sort(time);
        long high = ((long)(time[time.length-1]))*totalTrips;
        //System.out.println(high);
        long low =0;
        long res=-1;
        
        while(low<high){
            long mid = low + (high-low)/2;
            //System.out.println(mid);
            long sum=0;
            for(int t: time){
                sum += (mid/t);
            }
            
            if(sum < totalTrips){
                low = mid+1;
                res = mid+1;
            }else{
                high = mid;
                res = mid;
            }
            
        }
        
        return res;
    }

    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        int n = src.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = src.nextInt();
        }
        int totalTrips = src.nextInt();
        long res = minimumTime(arr, totalTrips);
        System.out.println(res);
    }
}
