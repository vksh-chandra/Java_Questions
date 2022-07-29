package Graph;

import java.io.*;
import java.util.*;

//Count of Strongly connected component in O(V+E).

//A strongly connected component (SCC) of a directed graph is a maximal strongly connected subgraph

public class KosarajuSCC {
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

		System.out.println(kosaraju(graph, n));
	}

	public static int kosaraju(ArrayList<ArrayList<Integer>> graph, int n) {
		boolean[] visited = new boolean[n];
		LinkedList<Integer> stack = new LinkedList<>();

		//run random dfs on graph
		//add to stack - > stack k top p humesa problematic edge k start wale direction k taraf ka node ayega
		for(int i=0; i<n; i++){
			if(visited[i]==false){
				dfs1(i, graph, stack, visited);
			}
		}

		//Reverse the Edges of graph - so that problametic component get reverse. (Transpose Graph)
		ArrayList<ArrayList<Integer>> ngraph = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			ngraph.add(new ArrayList<>());
		}

		for(int i=0; i<n; i++){
			ArrayList<Integer> nbrs = graph.get(i);
			for(int nbr: nbrs){
				ngraph.get(nbr).add(i);
			}
		}

		boolean[] vis = new boolean[n];
		int cycle=0;
		//now run dfs on stack 
		while(stack.size()>0){
			int nbr = stack.removeFirst();
			if(vis[nbr]==false){
				dfs2(ngraph, vis, nbr);
				cycle++;
			}
		}

		return cycle;

    }	

	public static void dfs1(int src, ArrayList<ArrayList<Integer>> graph, LinkedList<Integer> stack, boolean[] visited){
		//topological way m stack m dalnge

		visited[src] = true;
		ArrayList<Integer> nbrs = graph.get(src);
		for(int nbr: nbrs){
			if(visited[nbr]==false){
				dfs1(nbr, graph, stack, visited);
			}
		}
		stack.addFirst(src);

	}

	public static void dfs2(ArrayList<ArrayList<Integer>> ngraph, boolean[] visited, int src){

		if(visited[src]==true){
			return;
		}
		visited[src] = true;
		ArrayList<Integer> nbrs = ngraph.get(src);
		for(int nbr : nbrs){
			dfs2(ngraph, visited, nbr);
		}


	}

}
