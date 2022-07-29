package Graph;
//ITERATIVE TOPOLOGICAL SORTING

    //By using INDEGREE of vertices - >>  the number of head ends adjacent to a vertex is called the Indegree of the vertex 
                                        //and the number of tail ends adjacent to a vertex is its Outdegree 
    //valid only for Directed Acyclic Graph

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class KahnsAlgo {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st = br.readLine().split(" ");
		int n = Integer.parseInt(st[0]);
		int m = Integer.parseInt(st[1]);

		int[][] prerequisites = new int[m][2];
		for (int i = 0; i < m; i++) {
			st = br.readLine().split(" ");
			prerequisites[i][0] = Integer.parseInt(st[0]);
			prerequisites[i][1] = Integer.parseInt(st[1]);
		}
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < prerequisites.length; i++) {
			int u = prerequisites[i][0];
			int v = prerequisites[i][1];

			graph.get(v).add(u);
		}

		int[] ans = findOrder(n, graph);

		for (int val : ans) {
			System.out.print(val + " ");
		}
	}

	public static int[] findOrder(int n, ArrayList<ArrayList<Integer>> graph) {
        //jiska in-degree 0 hga wo top p ayega
        int[] indeg = new int[n];
        int[] ans = new int[n];
        int idx=0;

        //STEP 1->> calculate in-degree -> by visiting nbr and increment by one
        for(int i=0; i<n;i++){
            for(int nbr : graph.get(i)){
                indeg[nbr]++;
            }
        }
        
        //STEP 2-->> jiska indegree 0 hai usko queue m dal do
        LinkedList<Integer> queue = new LinkedList<>();
        for(int i=0; i<n; i++){
            if(indeg[i]==0){
                queue.addLast(i);
            }
        }

        //if indgeree kisi ka 0 nai hai to not possible to create topological sort

        while(queue.size()>0){
            int rem = queue.removeFirst();

            /*STEP 3 ->> remove kro 
                         ans m add kro
                         or uska indegeree minus 1 kr do
            */
            ans[idx++] = rem;
            for(int nbr : graph.get(rem)){
                indeg[nbr]--;
                //STEP 4->> agr kisi ka indegree 0 ho gaya too queue m add kr do
                if(indeg[nbr]==0){
                    queue.addLast(nbr);
                }
            }
            //repeat till size becomes 0
        }   

        //if idx == n then return ans else return -1;
        if(idx==n){
            return ans;
        }else{
            return new int[]{-1};
        }
    
	}
}