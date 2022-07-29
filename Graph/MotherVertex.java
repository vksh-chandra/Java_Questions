package Graph;

import java.io.*;
import java.util.*;

//A mother vertex in a graph G = (V, E) is a vertex v such that all other vertices in G can be reached by a path from v.

/*
	The idea is based on Kosaraju’s Strongly Connected Component Algorithm. 
	In a graph of strongly connected components, mother vertices are always vertices of source component in component graph
*/

public class MotherVertex{
    	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st = br.readLine().split(" ");
		int n = Integer.parseInt(st[0]);
		int m = Integer.parseInt(st[1]);

		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = br.readLine().split(" ");
			int u = Integer.parseInt(st[0]) - 1;
			int v = Integer.parseInt(st[1]) - 1;
			graph.get(u).add(v);
		}

		System.out.println(findMotherVertex(n, graph));
	}

    public static int findMotherVertex(int n, ArrayList<ArrayList<Integer>> graph){
		
		Stack<Integer> stack = new Stack<>();
		boolean[] visited = new boolean[n];
		//random order dfs and stack m add kr lo backtrack krte tym.
		for(int i=0; i<n; i++){
			if(visited[i]==false){
				dfs(graph, stack, visited, i);
			}
		}

		//stack ka top most node mother vertex hga.
		//WHY??  ->> jb backtrack krte hue dfs krnge too last m wai node add hga jis s sare node p ja skte haii.
		int ans= stack.pop();
		count =0;
		visited = new boolean[n];
		dfs(graph, visited, ans);

		if(count==n){
			//ans + 1 because indexing is 1 based and we made it 0 based my -1 
			return ans+1;
		}else{
			return -1;
		}

    }

	public static void dfs(ArrayList<ArrayList<Integer>> graph, Stack<Integer> stack, boolean[] visited, int src){

		visited[src] = true;
		ArrayList<Integer> nbrs = graph.get(src);
		for(int nbr : nbrs){
			if(visited[nbr]==false){
				dfs(graph, stack, visited, nbr);
			}
		}

		stack.push(src);
	}

	static int count;
	public static void dfs(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int src){
		//dfs m count kr lnge kya sb node visit kr rahe. Agr haan too true else false hga.
		visited[src] = true;
		count++;
		
		ArrayList<Integer> nbrs = graph.get(src);
		for(int nbr : nbrs){
			if(visited[nbr]==false){
				dfs(graph, visited, nbr);
			}
		}
	} 
       
    
}
