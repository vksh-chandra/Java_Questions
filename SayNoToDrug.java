/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class SayNoToDrug
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int i,n,k,l,j,m,x=0;
		
		for(i=0;i<t;i++)
		{
		    n = sc.nextInt();
		    k = sc.nextInt();
		    l = sc.nextInt();
		    m=0;
		    for(j=0;j<n;j++)
		    {
		        x = sc.nextInt();
		        if(x>m){
		            m=x;
		        }
		        
		    }
		    if(m==x){
		        System.out.println("Yes");
		        
		    }
		    else{
		    if (((l-1)*k + x)  > m)
		    {
		        System.out.println("Yes");
		    }
		    else{
		        System.out.println("No");
		    }}
		    
		}
	}
}

/* WHAT I TRIED
int n = src.nextInt();
            int k = src.nextInt();
            int l = src.nextInt();
            int[] array = new int[n];
            int max = Integer.MIN_VALUE;

            for(int i=0;i<n;i++){
                array[i] = src.nextInt();
                if(max<array[i]){
                    max = array[i];
                }
            }

            int res =0;
            
            if(max== array[n-1]){
                System.out.println("Yes");
            }
            else if(k<0 && max !=array[n-1]){
                System.out.println("No");
            }
            else{
                while(l!=1){
                    res = array[n-1]+k;
                    l--;
                    if(res>max){
                        break;
                    }
                }
                if(res>max){
                    System.out.println("Yes");
                }else{
                    System.out.println("No");
                }
            }
			*/