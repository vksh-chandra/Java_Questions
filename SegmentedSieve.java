//Initial Template for Java

import java.io.*;
import java.util.*;

class SegmentedSieve{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split("\\s+");
            long L = Long.parseLong(a[0]);
            long R = Long.parseLong(a[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.primeProduct(L, R));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static long mod = 1000000007;
    static long primeProduct(long l, long r){
        //make root of upper range
        long rootr = (long)Math.sqrt(r);
        int n = (int)(r-l+1);
        boolean[] arr = new boolean[n];
        Arrays.fill(arr, true);
        
        //get prime till root r
        ArrayList<Long> primes = sieve(rootr);
         
        //marking using prime 
        for(long prime: primes){
            
            long multiple = (long)Math.ceil((l*1.0)/prime);
            if(multiple==1)
                multiple++;
            
            long idx = multiple*prime - l;
            for(long j=idx; j<arr.length; j +=prime){
                if(arr[(int)j]){
                    arr[(int)j] = false;
                }
            }
        }
        
        long res = 1;
        for(long i=0; i<arr.length; i++){
            if(arr[(int)i]==true && i+l>1){
                res = (res * (i+l))%mod;
            }
            
        }
        
        return res % mod;
    }
    
    
    public static ArrayList<Long> sieve(long r){
        int n = (int)r+1;
        boolean[] arr = new boolean[n];
        ArrayList<Long> res = new ArrayList<>();
        
        Arrays.fill(arr, true);
        
        for(int i=2; i*i<arr.length; i++){
            
            if(arr[i]){
                for(int j = i+i; j<arr.length; j+=i){
                    arr[j] = false;
                }
                    
            }
            
        }
        
        for(int i=2; i<arr.length; i++){
            if(arr[i]==true){
                res.add((long)i);
            }
        }
        
        return res;
        
    }
    
}