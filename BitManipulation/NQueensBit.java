package BitManipulation;
//USING BRANCH AND BOUND OR BACKTRACKING

import java.io.*;
import java.util.*;

public class NQueensBit {

  public static void solution(boolean[][] board, int row, int cols, int ndiag, int rdiag, String asf) {
      
    if(row==board.length){
        System.out.println(asf+".");
        return;
    }  
      
    for(int col = 0; col< board[0].length; col++){
        int maskc = (1<<col);
        int maskn = (1<<(row+col));
        int maskr = (1<<(row-col+board.length-1));
        
        if((cols & maskc) ==0 && (ndiag & maskn) ==0 && (rdiag & maskr) ==0){
            cols ^= maskc;
            ndiag ^= maskn;
            rdiag ^= maskr;
            solution(board, row+1, cols, ndiag, rdiag, asf+row+"-"+col+", ");
            cols ^= maskc;
            ndiag ^= maskn;
            rdiag ^= maskr;
        }
    }  
      
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    boolean[][] board = new boolean[n][n];
    int cols = 0;
    int ndiag = 0;
    int rdiag = 0;
    solution(board, 0, cols, ndiag, rdiag, "");
    scn.close();
  }

}