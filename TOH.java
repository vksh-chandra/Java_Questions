import java.io.*;
import java.util.*;

public class TOH{

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner src = new Scanner(System.in);
        int n = src.nextInt();
        int a = src.nextInt();
        int b = src.nextInt();
        int c = src.nextInt();
        toh(n,a,b,c);
        src.close();
    }

    public static void toh(int n, int t1id, int t2id, int t3id){
        if(n==0){
            return;
        }
        toh(n-1, t1id, t3id, t2id);
        System.out.println(n+"["+t1id+" -> "+t2id+"]");
        toh(n-1, t3id, t2id, t1id);
    }

}