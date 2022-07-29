import java.util.*;
public class DistinctChar {    
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);

        //int n = src.nextInt();
        //src.nextLine();
        String str = src.nextLine();
        int len = str.length();
        int count=0;
        char[] ch = str.toCharArray();
        Arrays.sort(ch);
        for(int i=0; i<len-1; i++){
            if(ch[i]== ch[i+1]){
                count++;
            }
        }
        int sum = len-count;
        if(sum%2!=0){
            System.out.println("IGNORE HIM!");
        }
        else
        {
            System.out.println("CHAT WITH HER!");

        }
        src.close();

    }
}
