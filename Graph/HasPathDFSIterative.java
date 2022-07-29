package Graph;
import java.util.*;
import java.io.*;

/*
jo recursion s krte hai wo call stack m jata hai, to wo mxm 10k tak hi call ho skta hai... which can fail in linear graph.

y wala stack ka object hai, jiske pass call stack s zada memory haii...
*/

public class HasPathDFSIterative {
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
        Stack<Integer> stack = new Stack<>();
        
        boolean path = hasPath(graph, src, dest, visited, stack);
        System.out.println(path);
    }


    private static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, Stack<Integer> stack){
        
        stack.push(src);

        while(stack.size()>0){
            int rem = stack.pop();
            if(rem==dest){
                return true;
            } 

            if(visited[rem]==true){
                continue;
            }

            visited[src] = true;

            for(Edge e: graph[rem]){
                if(visited[e.nbr]==false){
                    stack.add(e.nbr);
                }
            }
        }
        return false;
    }
}

