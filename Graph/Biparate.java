package Graph;
import java.io.*;
import java.util.*;

/*
A graph is bipartite if the nodes can be partitioned into two independent sets A and B 
such that every edge in the graph connects a node in set A and a node in set B.
*/

public class Biparate {
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
   
   static class Pair{
       int v;
       int level;
       Pair(int v, int level){
           this.v = v;
           this.level = level;
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

      int[] visited = new int[vtces];
      Arrays.fill(visited, -1);
      
      for(int i=0; i<vtces;i++){
          if(visited[i]==-1){
              boolean res = getBipartite(graph, i, visited);
              if(res == false){
              System.out.println(false);
                return;
            }
          }
      }
      System.out.println(true);
   }
   
   public static boolean getBipartite(ArrayList<Edge>[] graph, int src, int[] visited){
       
       ArrayDeque<Pair> queue = new ArrayDeque<>();
       queue.add(new Pair(src, 0));
       
       while(queue.size()>0){
           
           Pair rem= queue.remove();
           
           if(visited[rem.v]!=-1){
               //for cyclic check for even or odd no. or nodes 
               if(rem.level != visited[rem.v]){
                   return false;
               }else{
                   return true;
               }
               
           }else{
               visited[rem.v]= rem.level;
           }
           for(Edge e: graph[rem.v]){
                   if(visited[e.nbr]==-1){
                       queue.add(new Pair(e.nbr, rem.level+1));
                   }
               }
           
       }
       return true;
   }
   
   
}