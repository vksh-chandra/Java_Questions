import java.util.*;

public class Demo {

  static class pair{
    int n;
    int m;
    pair(int n, int m){
      this.n = n;
      this.m = m;
    }
  }

	public static void main(String[] args) {	
	Scanner src = new Scanner(System.in);
    int max = Integer.MAX_VALUE;
    int row = src.nextInt();
    int col = src.nextInt();
    int tMat[][] = new int[row][col];
    int pMat[][] = new int[row][col];


    for(int i=0; i<row; i++) {
      for(int j=0; j<col; j++) {
        tMat[i][j] = max;
        pMat[i][j] = max;
      }
    }

    Queue<pair> queue = new LinkedList<pair>();
    int r = src.nextInt();

    for(int i=0; i<r; i++){
      int n = src.nextInt();
      int m = src.nextInt();
      tMat[n][m] = 0;
      queue.add(new pair(n,m));
    }

    int t = src.nextInt();

    while(queue.size() > 0){
      pair rem = queue.poll();
      int x = rem.n;
      int y = rem.m;
      
      if(x != 0 && tMat[x-1][y] == max){
        tMat[x-1][y] = tMat[x][y] + t;
        queue.add(new pair(x-1, y));
      }

      if(y!=0 && tMat[x][y-1]==max){
        tMat[x][y-1]=tMat[x][y]+t;
        queue.add(new pair (x,y-1));
      }

      if(x!=row-1 && tMat[x+1][y]==max){
        tMat[x+1][y] = tMat[x][y]+t;
        queue.add(new pair (x+1,y));
      }

      if(x!=col-1 && tMat[x][y]==max){
        tMat[x][y] = tMat[x][y]+t;
        queue.add(new pair(x,y+1));
    }

    }

    int a = src.nextInt();
    int b = src.nextInt();
    pMat[a][b] = 0;
    boolean k = false;
    if(pMat[a][b] < tMat[a][b]){
		queue.add(new pair (a,b));
    }

    while(queue.size()>0){
      pair pt = queue.poll();
      int x = pt.n;
      int y = pt.m;

      if(pMat[x][y]>=tMat[x][y])continue;
        if(y==0)k=true;
        if(x!=0 && pMat[x-1][y]==max){
            pMat[x-1][y]=pMat[x][y]+1;
            queue.add(new pair (x-1,y));
        }
        if(y!=0 && pMat[x][y-1]==max){
            pMat[x][y-1]=pMat[x][y]+1;
            queue.add(new pair(x,y-1));
        }
        if(x != row-1 && pMat[x+1][y]==max){
            pMat[x+1][y] = pMat[x][y]+1;
            queue.add(new pair(x+1,y));
        }
        if(y!=col-1 && pMat[x][y+1]==max){
            pMat[x][y+1]= pMat[x][y]+1;
            queue.add(new pair(x,y+1));
        }

    }

    if(k == true){
      System.out.print("Escape possible");
    }
    else{
      System.out.print("Escape not possible");
    }

	src.close();

  }
}