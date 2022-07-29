package DP;

import java.util.*;
public class DPArrangeBuilding {
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        long n = src.nextLong();
        //other approach than array (same question as binary string count)
        long ob =1;
        long os =1;

        for(int i=2;i<=n;i++){
            Long nb = os;
            Long ns = os+ob;
            os = ns;
            ob = nb;
        }
        long tot = os+ob;
        System.out.println(tot*tot);

        src.close();
    }
}
