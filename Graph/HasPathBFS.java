package Graph;
import java.util.*;
import java.io.*;

public class HasPathBFS {
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
        ArrayDeque<Integer> q = new ArrayDeque<>();
        
        boolean path = hasPath(graph, src, dest, visited, q);
        System.out.println(path);
    }

    //METHOD 1
    private static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, ArrayDeque<Integer> q){
        
        q.add(src);
        //visited[src] = true;
        //int n, rem=src;

        while(q.size()>0){
            int rem = q.removeFirst();
            if(rem==dest){
                return true;
            } 

            if(visited[rem]==true){
                continue;
            }

            visited[src] = true;

            for(Edge e: graph[rem]){
                if(visited[e.nbr]==false){
                    q.add(e.nbr);
                }
            }
        }
        return false;
    }


    //METHOD 2 - But WRONGG!!!!

    // private static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, ArrayDeque<Integer> q){
        
    //     q.add(src);
    //     visited[src] = true;
    //     int n, rem=src;

    //     while(q.size()>0){
    //         n = q.size();

    //         for(int i=0; i<n; i++){
    //             rem = q.removeFirst();    //is m agr do ya us s zada nikla to frst wala remove ho kr gayab ho jyega uska child kaha add hua?? 

    //             if(rem==dest){
    //                 return true;
    //             }
    //         }

                //y loop ko upar wala for loop m dalna hga tb ja k sayad sai hga
    //         for(Edge e: graph[rem]){
    //             if(visited[e.nbr]==false){
    //                 visited[src] = true;
    //                 q.add(e.nbr);
    //             }
    //         }
    //     }
    //     return false;
    // }

}
