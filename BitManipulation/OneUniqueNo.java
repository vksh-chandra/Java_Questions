package BitManipulation;

import java.io.*;
import java.util.*;

public class OneUniqueNo{

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for(int i = 0 ; i < n; i++){
      arr[i] = scn.nextInt();
    }
    //using associative property of java.
    //a^b^c^d^a^e^b = a^a^b^b^c^d^e (a^a=0 & a^0 = a) so same one will be dead.
    
    int x =0;
    for(int i=0;i<n;i++){
        x = x^arr[i];
    }
    System.out.println(x);
    scn.close();
  }

}
