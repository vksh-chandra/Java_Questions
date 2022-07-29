package Graph;
/*
EDGE FORM OF ARTICULATION POINT
    An edge in an undirected graph is a Bridge iff 
    removing it disconnects the graph. You have to print all the Bridges of the given graph.
*/


import java.util.*;
import java.io.*;

class CriticalConnection {
  static int time;
  static int[] disc;
  static int[] low;
  static int[] parent;
  static boolean[] visited;

  public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> edges) {
    
    disc = new int[n];
    low = new int[n];
    parent = new int[n];
    visited = new boolean[n];
    time =0;

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<edges.size(); i++){
            int u = edges.get(i).get(0);
            int v = edges.get(i).get(1);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        List<List<Integer>> ans = new ArrayList<>();

        dfs(0, graph, ans);
        return ans;

  }

  public  static void dfs(int src, ArrayList<ArrayList<Integer>> graph, List<List<Integer>> ans){
        
        disc[src] = low[src] = time;
        time++;
        visited[src] = true;

        ArrayList<Integer> nbrs = graph.get(src);

        for(int i=0; i<nbrs.size(); i++){
            int nbr = nbrs.get(i);
            if(parent[src]==nbr){
                continue;
            }else if(visited[nbr]==true){
                low[src] = Math.min(low[src], disc[nbr]);
            }else{
                parent[nbr] = src;
                
                dfs(nbr, graph, ans);
                
                low[src] = Math.min(low[src], low[nbr]);
                if(low[nbr]> disc[src]){
                    List<Integer> subcomp = new ArrayList<>();
                    subcomp.add(src);
                    subcomp.add(nbr);
                    ans.add(subcomp);
                }
            }
        }
    }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] st = br.readLine().split(" ");
    int n = Integer.parseInt(st[0]);
    int e = Integer.parseInt(st[1]);
    List<List<Integer>> edges = new ArrayList<>();


    for (int i = 0; i < e; i++) {
      edges.add(new ArrayList<>());
      st = br.readLine().split(" ");
      edges.get(i).add(Integer.parseInt(st[0]));
      edges.get(i).add(Integer.parseInt(st[1]));
    }

    System.out.println(criticalConnections(n, edges));

  }

}
