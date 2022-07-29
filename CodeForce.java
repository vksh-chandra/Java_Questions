import java.util.*;
public class CodeForce {
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);

        String str = src.nextLine();
        str = str.toLowerCase();

        if(str.toLowerCase().replaceAll("[^a-z]", "").replaceAll("(.)(?=.*\\1)", "").length() == 26){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
        src.close();


        // if(!str.matches(".*[^a-z].*")){
        //     System.out.println("NO");
        // }
        // else{
        //     System.out.println("YES");
        // }
        // int[] p = new int[4];
        // int count=0;
        // //int flag =0;
        // for(int i=0;i<4;i++){
        //     p[i] = src.nextInt();
        // }
        // for(int i=0;i<4;i++){
        //     for(int j=i+1;j<4;j++){
        //         if(p[i]==p[j]){
                   
        //         }
        //     }
        // }
        // System.out.println(count);
    }
}
