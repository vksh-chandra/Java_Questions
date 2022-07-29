package Graph;

//USING DSU
/* 
    Given an m*n matrix mat, Originally, the 2D matrix is all 0 which means there is only sea in the matrix. 
    The list pair has k operator and each operator has two integer A[i].x, A[i].y means that you can change the grid mat[A[i].x][A[i].y] from sea to island. 
    Return how many island are there in the matrix after each operator.You need to return an array of size K.
*/

import java.util.*;
import java.io.*;

public class NoOfIsland2 {
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] st = br.readLine().split(" ");
    int m = Integer.parseInt(st[0]);
    int n = Integer.parseInt(st[1]);
    int q = Integer.parseInt(st[2]);

    int[][] pos = new int[q][2];
    for (int i = 0; i < q; i++) {
      st = br.readLine().split(" ");
      pos[i][0] = Integer.parseInt(st[0]);
      pos[i][1] = Integer.parseInt(st[1]);
    }

    System.out.println(numIslands2(m, n, pos));
  }

  public static List<Integer> numIslands2(int m, int n, int[][] positions) {
    int[] parent = new int[m*n];
    int[] rank = new int[m*n];
    Arrays.fill(parent, -1);
    Arrays.fill(rank, 1);

    int count=0;
    List<Integer> island = new ArrayList<>();

    for(int i=0; i<positions.length;i++){
      int row = positions[i][0];
      int col = positions[i][1];
      
      int cellNo = row*n+col;
      if(parent[cellNo] != -1){
        island.add(count);
        continue;
      }
      parent[cellNo] = cellNo;
      count++;

      int[][] dir = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
      for(int j=0; j<dir.length; j++){
        int rowdash = row + dir[j][0];
        int coldash = col + dir[j][1];

        int celdash = rowdash*n + coldash;
        if(rowdash<0 || coldash <0 || rowdash>=m || coldash >=n || parent[celdash]==-1){
          continue;
        }

        int lx = find(cellNo, parent);
        int ly = find(celdash, parent);
        if(lx != ly){
          if(rank[lx]>rank[ly]){
            parent[ly] = lx;
          }else if(rank[ly]>rank[lx]){
            parent[lx] = ly;
          }else{
            parent[ly] = lx;
            rank[lx]++;
          }
          count--;
        }

      }
      island.add(count);
    }


    return island;
  }

  public static int find(int x, int[] parent){
    if(parent[x]==x){
      return x;
    }
    int temp = find(parent[x], parent);
    parent[x] = temp;
    return temp;
  }

}
