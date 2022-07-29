import java.util.*;

public class Anagram2 {
    public static int minSteps(String s, String t) {
        int[] ch = new int[26];
        Arrays.fill(ch, 0);
        
        for(char c: s.toCharArray()){
            ch[c-'a']++;
        }
        
        for(char c: t.toCharArray()){
            ch[c-'a']--;
        }
        
        int count=0;
        for(int c : ch){
            if(c!=0){
                count += Math.abs(c);
            }
        }
        return count;
        
    }
    public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        String a = scan.nextLine();
        String b = scan.nextLine();
        scan.close();
        int ret = minSteps(a, b);
        System.out.println("Min steps to make anagram "+ ret);
    }
}
