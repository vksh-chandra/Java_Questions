package Graph;
import java.util.*;
import java.io.*;

public class HasPathDFS {
    public static class Edge{
        
        int src;      //virtices
        int nbr;      //neighbour
        int wt;     //weight
        Edge(int src, int nbr, int wt){
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vtces = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[vtces];

        for(int i=0; i<vtces;i++){
            graph[i] = new ArrayList<>();
        }

        int edges = Integer.parseInt(br.readLine());
        for(int i=0; i<edges;i++){
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int wt = Integer.parseInt(parts[2]);

            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }

        //read source and destination
        int src = Integer.parseInt(br.readLine());
        int dest = Integer.parseInt(br.readLine());

        boolean[] visited = new boolean[vtces];
        boolean path = hasPath(graph, src, dest, visited);
        System.out.println(path);
    }

    private static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited){
        if(src==dest){
            return true;
        }
        
        visited[src] = true;
        /*dfs has been used here
            first we travel to node then we discover its child/neighbour first
            then we travel to other nodes.
        */
        for(Edge edge: graph[src]){
                if(visited[edge.nbr]==false){
                    boolean res = hasPath(graph, edge.nbr, dest, visited);
                    if(res){
                        return true;
                    }
                }
        }
        return false;
        
    }
}
