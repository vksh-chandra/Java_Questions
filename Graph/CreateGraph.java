package Graph;
import java.util.*;
import java.io.*;

//CREATE GRAPH USING ARRAYLIST

public class CreateGraph{
    public static class Edge{
        
        int src;      //virtices
        int nbr;      //neighbour
        int wt;       //weight
        Edge(int src, int nbr, int wt){
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vtces = Integer.parseInt(br.readLine());

        //Array of ArrayList
        ArrayList<Edge>[] graph = new ArrayList[vtces];

        //frst we will create new arrayList in front of each index
        //as initially each index has null value. SO we have to initialize new arrayList in font of them
        for(int i=0; i<vtces;i++){
            graph[i] = new ArrayList<>();
        }

        int edges = Integer.parseInt(br.readLine());
        //create edges of graph
        for(int i=0; i<edges;i++){
            //take input as string from buffer reader. Then split it on space.
            String[] parts = br.readLine().split(" ");
            //extract both vertices and weight from string array
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int wt = Integer.parseInt(parts[2]);

            //now, create edges from all these vertices
            //values will be in form of
            //source, destination, weight
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }

    }
}
