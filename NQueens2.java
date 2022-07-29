import java.util.*;

//BRANCH AND BOUND TECHNIQUE

public class NQueens2 {

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    boolean[][] board = new boolean[n][n];
    //write your code here

    //block the column
    boolean[] cols = new boolean[n];
    //block row+col
    boolean[] ndig = new boolean[2*n-1];
    //row-col will be common
    //block row-col + n-1;
    boolean[] rdig = new boolean[2*n-1];
    nQueen(board, cols, ndig, rdig, 0, "");
    scn.close();
  }

  public static void nQueen(boolean[][] board, boolean[] cols, boolean[] ndig, boolean[] rdig, int row, String asf){
    if(row==board.length){
      System.out.println(asf+".");
      return;
    }

    for(int col=0; col<board.length; col++){
      if(cols[col]==false && ndig[row+col]==false && rdig[row-col+board.length-1]==false){
        cols[col]= true;
        ndig[row+col]= true;
        board[row][col] = true;
        rdig[row-col+board.length-1] = true;
        nQueen(board, cols, ndig, rdig, row+1, asf+row+"-"+col+", ");
        cols[col]= false;
        ndig[row+col]= false;
        rdig[row-col+board.length-1] = false;
        board[row][col] = false;
      }
    }

  }


}
