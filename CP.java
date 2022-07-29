import java.util.*;
import java.io.*;

public class CP
{   
    public static String getRes(String s1, String s2){
        //for impossible
        if(s1==null || s2==null){
            return "IMPOSSIBLE";
        }

        int len1 = s1.length();
        int len2 = s2.length();

        if(len1>len2){
            return "IMPOSSIBLE";
        }

        int count =0;
        
        // if(len1==len2){
        //     for(int i=0, j=0; i<s1.length() && j<s2.length();i++, j++){
        //         char c1 = s1.charAt(i);
        //         char c2 = s2.charAt(j);
        //         if(c1!=c2){
        //             return "IMPOSSIBLE";
        //         }
        //     }
        // }else{
        //     int i=0, j=0;
        //     while(i<len1 && j<len2){
        //         char c1 = s1.charAt(i);
        //         char c2 = s2.charAt(j);
        //         if(c1!=c2 ){
        //             if(Math.abs(c2-c1)==32){
        //                 return "IMPOSSIBLE";
        //             }
        //             else if(len2>len1){
        //                 count++;
        //             }
        //         }else if(c1==c2){
        //             i++;
        //         }
        //         j++;
        //     }
        //     if(j<len2){
        //         //System.out.println("inside while");
        //         count += len2-j;
        //     }
        // }
        // return count+"";

        int i=0, j=0;
        while(i<len1 && j<len2){
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(j);
            if(c1==c2){
                i++;
            }else{
                count++;
            }
            j++;
        }
        if(i==len1){
            count += len2-j;
            return count+"";
        }else{
            return "IMPOSSIBLE";
        }

    }
    public static void main (String[] args) throws java.lang.Exception
	{
        
		FastReader src =new FastReader();
	    int t=src.nextInt();
	    
	    while(t-->0)
	    {   
            String input = src.nextLine();
            String out = src.nextLine();
            System.out.println(getRes(input, out));
            
        }
    }
	
	
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader()
        {
            br = new BufferedReader(
                new InputStreamReader(System.in));
        }
 
        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt() { return Integer.parseInt(next()); }
 
        long nextLong() { return Long.parseLong(next()); }
 
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
        
        float nextFloat()
        {
            return Float.parseFloat(next());
        }
 
        String nextLine()
        {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
        
        int[] readArray(int n) {
			int[] a=new int[n];
			for (int i=0; i<n; i++) a[i]=nextInt();
			return a;
		}
    }
    static int getXor(int a){
        if(a%4==0){
            return a;
        }else if(a%4==1){
            return 1;
        }else if(a%4==2){
            return a+1;
        }else{
            return 0;
        }
    }
}