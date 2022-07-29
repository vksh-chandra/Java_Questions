import java.util.*;

public class anagram {
    static boolean isAnagram(String a, String b) {
        // Complete the function
        int lenA = a.length();
        int lenB = b.length();
        
        if(lenA!= lenB)
            return false;
        char[] A = a.toCharArray();
        char[] B = b.toCharArray();
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        for(int i=0; i<a.length();i++)
        {
            if(A[i]!=B[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        String a = scan.nextLine();
        String b = scan.nextLine();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}