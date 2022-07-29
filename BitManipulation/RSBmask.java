//print the right-most set bit mask.
package BitManipulation;

import java.io.*;
import java.util.*;

public class RSBmask {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();    
    //int comps = n & (~n+1);
    int comps = n & -n;
    
    // -n which is 2's complement of n
    //2's comp of n = (~n) +1 = -n
    
    System.out.println(Integer.toBinaryString(comps));
    scn.close();
  }

}