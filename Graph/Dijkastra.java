package Graph;
//SHORTEST PATH IN WEIGHT

//Fails on Negative Edge Weight

import java.io.*;
import java.util.*;

public class Dijkastra {
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

      int src = Integer.parseInt(br.readLine());
      boolean[] visited = new boolean[vtces];
      //using lambda function to compare its weight for pair class.
      PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
       return a.wt-b.wt;   
      });
      
      //add first path
      pq.add(new Pair(src, src+"", 0));
      while(pq.size()>0){
          
          Pair rem = pq.remove();   //remove (in this case nodes with lower weight will get remove)
          if(visited[rem.v]==true){  //check if it is visited or not
              continue;
          }
          visited[rem.v]=true; //if not then mark visited
          
          System.out.println(rem.v+" via "+rem.psf+" @ "+rem.wt); //do work you have to do like print or add in list or count etc.
          
          //apply bfs in remaining graph
          for(Edge e: graph[rem.v]){
              if(visited[e.nbr]==false){
                  pq.add(new Pair(e.nbr, rem.psf+e.nbr, rem.wt+e.wt));
              }
          }
      }
   }
   
   public static class Pair{
       int v;
       String psf;
       int wt;
       Pair(int v, String psf, int wt){
           this.v = v;
           this.psf= psf;
           this.wt = wt;
       }
   }
   
   
}