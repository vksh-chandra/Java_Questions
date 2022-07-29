package Graph;

/*
    A vertex in an UNDIRECTED graph is an articluation point iff 
    removing it disconnects the graph. You have to find the number of articulation point in the given graph.
*/

import java.util.*;

class ArticulationPoint {
  static int time = 0; 

  private static void AP_Bridges(ArrayList<ArrayList<Integer>> graph, int[] disc, int[] low, int[] parent,boolean[] Apoint, boolean[] visited, int src) {
        //discovey array will store time of its discovery
        //low array ?? ->> y wo value store krega ki agr dfs path ko ignore krte hai to lowest kis node tak pauch jyega bina wo dfs path use kie
      disc[src] = low[src] = time;
      time++;
      visited[src] = true;
      int count=0;

      ArrayList<Integer> nbrs = graph.get(src);
                                   
      for(int i=0; i<nbrs.size(); i++){
        int nbr = nbrs.get(i);

        //visited hai or mera parent hai. mtlb usi k thourgh aa rkhe hai (undirected graph hai na islie wapas ja skta hai)
        if(parent[src]==nbr){
            continue;
        }
        //agr visited mila too low array change kro --> apna low or uska discovery value ka minimum l lo.
        //iska kya mtlb hga?? - >> agr jis path s aye hai is index p usko na use kre to kis minimum value p ja skte hai wo store krega

        else if(visited[nbr]==true){
            low[src] = Math.min(low[src], disc[nbr]);
        }

        //kuch nai hai too aage dfs call kr do.
        else{
            parent[nbr] = src;
            count++;
            AP_Bridges(graph, disc, low, parent, Apoint, visited, nbr);

            //BACKTRACK 
            
            //wapas ane tym apne neighbour ka lowest or apna lowest ka minimum l lo.
                //kuki agr wo kahi ja skta hai to uske through tum v waha ja skte ho. current path ko ignore kr k
            low[src] = Math.min(low[src], low[nbr]);

            if(parent[src]==-1){
                if(count>=2){
                    Apoint[src] = true;
                }
            }else{
                //agr mera nbr ka low mere discovery s zada hai to iska mtlb wo mujh tak v nai pauch pa raha. Fr main(src) AP hua.
                if(low[nbr]>= disc[src]){
                    Apoint[src] = true;
                }
            }
          }
        }                          
    
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);


    int v = scn.nextInt();
    int e = scn.nextInt();
    ArrayList<ArrayList<Integer>> g = new ArrayList<>();
    for (int i = 0; i < v; i++) {
      g.add(new ArrayList<>());
    }
    for (int i = 0; i < e; i++) {
      int v1 = scn.nextInt();
      int v2 = scn.nextInt();
      g.get(v1 - 1).add(v2 - 1);
      g.get(v2 - 1).add(v1 - 1);
    }

    boolean A_point[] = new boolean[v];
    int[] parent = new int[v];
    parent[0] = -1;
    AP_Bridges(g, new int[v], new int[v], parent, A_point, new boolean[v], 0);
    int count = 0;
    for (int i = 0; i < v; i++) {
      if (A_point[i]) {
        count++;
      }
    }
    System.out.println(count);

    scn.close();

  }

}
