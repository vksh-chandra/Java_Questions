package Graph;

import java.util.*;
import java.io.*;

public class Redundant_Conn2 {
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] st = br.readLine().split(" ");
    int n = Integer.parseInt(st[0]);

    int[][] pos = new int[n][2];
    for (int i = 0; i < n; i++) {
      st = br.readLine().split(" ");
      pos[i][0] = Integer.parseInt(st[0]);
      pos[i][1] = Integer.parseInt(st[1]);
    }

    int[] ans = findRedundantDirectedConnection(pos);
    System.out.println(ans[0] + " " + ans[1]);
  }


  static int[] parent;
  static int[] rank;
  public static int[] findRedundantDirectedConnection(int[][] edges) {
    int n = edges.length;
        parent = new int[n+1];
        rank = new int[n+1];
        for(int i=0; i<=n;i++){
            parent[i] = i;
            rank[i]=1;
        }
        
        int[] indeg = new int[n+1];
        Arrays.fill(indeg, -1);
        int bl1 = -1;
        int bl2 = -1;
        for(int i=0; i<n;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            if(indeg[v]==-1){
                indeg[v] = i;
            }else{
                bl1 = i;
                bl2 = indeg[v];
            }
        }
        
        for(int i=0; i<n; i++){
            if(i==bl1){
                continue;
            }
            int u = edges[i][0];
            int v = edges[i][1];
            boolean flag = union(u,v);
            if(flag==true){
                if(bl1==-1){
                    return edges[i];
                }else{
                    return edges[bl2];
                }
            }
        }
        
        return edges[bl1];
  }
  public static boolean union(int x, int y){
        int lx = find(x);
        int ly = find(y);
        if(lx!=ly){
            if(rank[lx]>rank[ly]){
                parent[ly] = lx;
            }else if(rank[ly]>rank[lx]){
                parent[lx] = ly;
            }else{
                parent[ly] = lx;
                rank[lx]++;
            }
            
            return false;
        }else{
            return true;
        }
    }
    
    public static int find(int x){
        if(parent[x]==x){
            return x;
        }
        int temp = find(parent[x]);
        parent[x] = temp;
        return temp;
    }

}
