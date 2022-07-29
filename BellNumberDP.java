import java.util.*;

public class BellNumberDP {

    int BellNum(int n){
        int[][] bell = new int[n+1][n+1];
        bell[0][0] = 1;
        
        for(int i=1;i<=n;i++){
            bell[i][0] = bell[i-1][i-1];
            for(int j=1; j<=i;j++){
                bell[i][j] = bell[i-1][j-1] + bell[i][j-1];
            }
            
        }
        return bell[n][0];
    }
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        int n = src.nextInt();

        BellNumberDP bell = new BellNumberDP();
        System.out.println(bell.BellNum(n));
        src.close();

    }
}
