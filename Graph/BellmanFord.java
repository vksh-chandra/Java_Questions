package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//Single source , Shortest Path detection in DIRECTED Graph
    //works on negative edge weight
    //failed at negative weight cycle in graph -> kuki negative weight cycle k lie shortest path nai hta

public class BellmanFord {
	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] st=br.readLine().split(" ");
        
        int n=Integer.parseInt(st[0]);
        int m=Integer.parseInt(st[1]);
        
        //{src, dst, weight}
        int[][] arr=new int[m][3];
        
        for(int i=0;i<m;i++)
        {
            st=br.readLine().split(" ");
            arr[i][0]=Integer.parseInt(st[0])-1;
            arr[i][1]=Integer.parseInt(st[1])-1;
            arr[i][2]=Integer.parseInt(st[2]);
        }

        //is Array m-> given source s ith vertex tak ka shortes path, in terms of edge weight, store krnge.
        int[] path = new int[n];
        
        //STEP 1 ->> fill infinity to every index expect source. source will have 0 weight.
        Arrays.fill(path, Integer.MAX_VALUE);
        path[0] = 0;
        
        //STEP 2->? fix the direction to treaverse and iterate for vtces-1 time.
                //why v-1 ?? - >> kuki mxm v-1 edge create hga linear graph mein and 
                                    //cyclic m zada hua v to pura cycle travel nai krte kvi (watch video at 19min)
        for(int i=0; i<n-1; i++){
            for(int j=0; j<m; j++){
                int u = arr[j][0];
                int v = arr[j][1];
                int wt = arr[j][2];
                
                if(path[u]==Integer.MAX_VALUE){
                    continue;
                }
                //use relaxing method -> path[u]+wt < path[v], then update

                //ith iteration -> shortes path calculate hta hai jiska path length <= i hta hai
                if(path[u]+wt < path[v]){
                    path[v] = path[u]+wt;
                }   
            }
        }

        for(int i=1; i<n;i++){
            if(path[i]!=Integer.MAX_VALUE){
                System.out.print(path[i]+" ");
            }else{
                System.out.print("1000000000 ");
            }
        }
        System.out.println();
        
        
	}
}
