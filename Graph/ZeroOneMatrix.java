package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class ZeroOneMatrix {
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] st = br.readLine().split(" ");
    int n = Integer.parseInt(st[0]);
    int m = Integer.parseInt(st[1]);

    int[][] arr = new int[n][m];

    for (int i = 0; i < n; i++) {
      st = br.readLine().split(" ");
      for (int j = 0; j < m; j++) {
        arr[i][j] = Integer.parseInt(st[j]);
      }
    }

    int[][] ans = updateMatrix(arr);

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        System.out.print(ans[i][j] + " ");
      }
      System.out.println();
    }

  }

  //======================++++++========================================

  public static class Pair{
    int x;
    int y;
    Pair(int x, int y){
      this.x = x;
      this.y = y;
    }
  }

  static int[][] dir = {{1,0}, {-1,0}, {0,1},{0,-1}};

  public static int[][] updateMatrix(int[][] matrix) {

    LinkedList<Pair> queue = new LinkedList<>();
    for(int i=0; i<matrix.length; i++){
      for(int j=0; j<matrix[0].length; j++){
        if(matrix[i][j]==0){
          queue.addLast(new Pair(i,j));
        }else{
          matrix[i][j] = -1;
        }
      }
    }

    while(queue.size()>0){
      Pair rem = queue.removeFirst();

      for(int i=0; i<4; i++){
        int rd = rem.x + dir[i][0];
        int cd = rem.y + dir[i][1];
        if(rd<0 || cd<0 || rd>=matrix.length || cd>=matrix[0].length || matrix[rd][cd]==0){
          continue;
        }
        if(matrix[rd][cd]<0){
          //agr -1 hai too jaha s aya uska value +1 wo level ho jyega iska
          matrix[rd][cd] = matrix[rem.x][rem.y]+1;
          queue.addLast(new Pair(rd, cd));
        }
      }

    }
    return matrix;

  } 
}

