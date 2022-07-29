package Graph;
import java.io.*;
import java.util.*;

public class PerfectPair {
    public static class Edge{
        
        int src;      //virtices
        int nbr;      //neighbour
        Edge(int src, int nbr){
            this.src = src;
            this.nbr = nbr;
        }
    }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int n = Integer.parseInt(br.readLine());
      int k = Integer.parseInt(br.readLine());
      
      ArrayList<Edge>[] graph = new ArrayList[n];

        //frst we will create new arrayList in front of each index
        //as initially each index has null value. SO we have to initialize new arrayList in font of them
        for(int i=0; i<n;i++){
            graph[i] = new ArrayList<>();
        }

        //create edges of graph
        for(int i=0; i<k;i++){
            //take input as string from buffer reader. Then split it on space.
            String[] parts = br.readLine().split(" ");
            //extract both vertices and weight from string array
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            //int wt = Integer.parseInt(parts[2]);

            //now, create edges from all these vertices
            //values will be in form of
            //source, destination, weight
            graph[v1].add(new Edge(v1, v2));
            graph[v2].add(new Edge(v2, v1));
        }
        ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
        boolean[] visited = new boolean[n];
        for(int i=0; i<n;i++){
            if(visited[i]==false){
                ArrayList<Integer> subcomps = new ArrayList<>();
                createTreeGetComp(graph, i, subcomps, visited);
                comps.add(subcomps);
            }
        }
      int pair=0;
      for(int i=0;i<comps.size();i++){
          for(int j=i+1; j<comps.size();j++){
              int mul = comps.get(i).size()*comps.get(j).size();
              pair +=mul;
          }
      }
      System.out.println(pair);
   }
   
   public static void createTreeGetComp(ArrayList<Edge>[] graph, int src, ArrayList<Integer> subcomps, boolean[] visited){
       
       visited[src] = true;
       subcomps.add(src);
       
       for(Edge edge: graph[src]){
           if(visited[edge.nbr]==false){
               createTreeGetComp(graph, edge.nbr, subcomps, visited);
           }
       }
       
   }
   
   

}
