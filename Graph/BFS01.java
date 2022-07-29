package Graph;
import java.io.*;
import java.util.*;

//Logic - > MINIMUM NUMBER OF EDGES TO REVERSE IN ORDER TO HAVE ATLEAST ONE PATH FROM 1 TO N


/*
You are given 2 integers N and M , N is the number of vertices, M is the number of edges. 
You'll also be given ai and bi where ai and bi represents an edge from a vertex ai to a vertex bi.

You have to find the minimum number of edges you have to REVERSE in order to have atleast one path from vertex 1 to N,
 where the vertices are numbered from 1 to N.
*/

public class BFS01 {

    static class Edge{
        int src;
        int nbr;
        int wt;
        Edge(int src, int nbr, int wt){
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    static class Pair{
        int val;
        int wt;
        Pair(int val, int wt){
            this.val = val;
            this.wt = wt;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
        int m = Integer.parseInt(st[1]);

        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++){
            String[] parts = br.readLine().split(" ");
            int u = Integer.parseInt(parts[0])-1;
            int v = Integer.parseInt(parts[1])-1;

            //add given edge with cost 0
            graph.get(u).add(new Edge(u, v, 0));
            //add the reverse egde with cost 1
            graph.get(v).add(new Edge(v, u, 1));

        }

        boolean[] visited = new boolean[n];

        LinkedList<Pair> queue = new LinkedList<>();
        queue.addLast(new Pair(0, 0));

        while(queue.size()>0){
            Pair rem = queue.removeFirst();
            if(rem.val==n-1){
                System.out.println(rem.wt);
                return;
            }

            visited[rem.val] = true;
            for(Edge e: graph.get(rem.val)){
                if(visited[e.nbr]==true){
                    continue;
                }

                //nbr tak jane ka cost 0 hai too add kr too nai to cost ko 1 s badha do
                if(e.wt==0){
                    queue.addFirst(new Pair(e.nbr, e.wt));
                }else{
                    queue.addLast(new Pair(e.nbr, e.wt+1));
                }

            }

        }

        System.out.println("-1");
        return;
    }

}
