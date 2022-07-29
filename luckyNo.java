import java.util.*;
public class luckyNo {
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);

        long n = src.nextLong();
        String str = Long.toString(n);
        int flag =0;
        int count=0;
        
        int len = str.length();
        if(len>1){
            for(int i=0;i<len;i++){
                if(str.charAt(i)== '4' || str.charAt(i)=='7'){
                    flag =1;
                    count++;
                }
                else{
                    flag =0;
                    break;
                }
            }
        }else{
            flag =0;
        }

        //System.out.println(count);
        
        if(flag == 1)
        {
            if(count == 4 || count == 7)
                System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
        src.close();

        
    }
}
