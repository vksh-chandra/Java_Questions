import java.util.*;

class DigitSum{
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);

        int n= src.nextInt();
        long[] p = new long[n];
        int[] res = new int[n];
        int count=0;

        for(int i=0;i<n;i++){
            p[i] = src.nextInt();
            count =0;
            for(int j=1; j<=p[i];j++){
                boolean r = sum(j, j+1);
                if(r == true){
                    res[i]= ++count;
                }
            }
        }

        for(int i=0;i<n;i++){
            System.out.println(res[i]);
        }
        src.close();

    }

    public static boolean sum(long n, long m){
        int s1 =0;
        int s2 =0;
        while(n!=0){
            int rem = (int)n%10;
            s1 += rem;
            n /=10;
        }

        while(m!=0){
            int rem = (int)m%10;
            s2 += rem;
            m /=10;
        }
        if(s2<s1){
            return true;
        }
        else{
            return false;
        }

    } 
}
