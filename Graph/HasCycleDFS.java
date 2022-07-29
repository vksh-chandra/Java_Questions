package Graph;
import java.io.*;
import java.util.*;

public class HasCycleDFS {
   static class Edge {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt) {
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
      }
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }

      boolean[] discovered = new boolean[vtces];
        
        for(int i=0; i<vtces; i++){
            if(discovered[i]==false){
                boolean cycle = DFS(graph, 0, discovered, -1);
                if(cycle){
                    System.out.println(true);
                    return;
                }
            }
        }
        System.out.println(false);
   }
   
   public static boolean DFS(ArrayList<Edge>[] graph, int v, boolean[] discovered, int parent)
    {
        // mark the current node as discovered
        discovered[v] = true;
 
        // do for every edge 
        for (Edge e: graph[v])
        {
            // if `e.nbr` is not discovered
            if (!discovered[e.nbr])
            {
                if (DFS(graph, e.nbr, discovered, v)) {
                    return true;
                }
            }
 
            // if `e.nbr` is discovered, and `e.nbr` is not a parent
            else if (e.nbr != parent)
            {
                // we found a back-edge (cycle)
                return true;
            }
        }
 
        // No back-edges were found in the graph
        return false;
    }
   
}
