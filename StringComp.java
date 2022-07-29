import java.util.*;
public class StringComp {
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
 
        int a = src.nextInt();
        int b = src.nextInt();
        // int w = src.nextInt();
        // int sum =0;
        // for(int i=1;i<=w;i++){
        //     sum += i*k;
        // }
        // if(n>sum){
        //     System.out.println(0);
        // }
        // else{
        //     int res = sum-n;
        //     System.out.println(res);
        // }

        int count=0;
        while(a<=b){
            a = 3*a;
            b = 2*b;
            count++;
        }
        System.out.println(count);

        src.close();


    }
}
