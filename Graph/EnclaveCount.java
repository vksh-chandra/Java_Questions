package Graph;

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.*;

//COUNT ALL 1 WHO ARE NOT CONNECTED WITH BORDER IN ANY WAYS

class EnclaveCount {

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] st = br.readLine().split(" ");
    int m = Integer.parseInt(st[0]);
    int n = Integer.parseInt(st[1]);

    int[][] arr = new int[m][n];

    for (int i = 0; i < m; i++) {
      st = br.readLine().split(" ");
      for (int j = 0; j < n; j++) {
        arr[i][j] = Integer.parseInt(st[j]);
      }
    }

    System.out.println(numEnclaves(arr));

  }

  public static int numEnclaves(int[][] arr) {
      
      for(int i=0; i<arr.length; i++){
        for(int j=0; j<arr[0].length; j++){
          if(i==0 || j==0 || i==arr.length-1 || j== arr[0].length-1){
            if(arr[i][j]==1){
              dfs(arr, i, j);
            }
          }
        }
      }

      int count=0;
      for(int i=0; i<arr.length; i++){
        for(int j=0; j<arr[0].length; j++){
          if(arr[i][j]==1){
            count++;
          }
        }
      }

    return count;

  }

  static int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1,0}};

  public static void dfs(int[][] arr, int row, int col){
      arr[row][col] = 0;

      for(int i=0; i<4; i++){
        int rd = row + dir[i][0];
        int cd = col + dir[i][1];
        if(rd<0 || cd<0 || rd>=arr.length || cd>=arr[0].length || arr[rd][cd]==0){
          continue;
        }
        dfs(arr, rd, cd);
      }

  }

}
