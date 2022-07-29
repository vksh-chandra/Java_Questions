import java.util.*;
public class Tram {
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);

        int n = src.nextInt();
        int[] res = new int[n];
        int p=0;
        for(int i=0; i<n;i++){
            int a = src.nextInt();
            int b = src.nextInt();
            if(i==0)
            {
                p=b;
                res[i] = b;
            }
            else{
                p = res[i-1]-a;
                p = Math.abs(p);
                res[i] = b+p;
            }
        }
        Arrays.sort(res);
        //System.out.println(Arrays.toString(res));
        System.out.println(res[n-1]);

        // for(int i=1; i<n1; i++){
        //     if(i%2!=0){
        //         sum=sum+a[i];
        //         al.add(sum);
        //     }
        //     else{
        //         sum=sum-a[i];
     
        //     }
        src.close();
    }
}
