import java.util.*;
public class pangram{
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);

        src.nextLine();
        String str = src.nextLine();
        str = str.toLowerCase();

        if(str.toLowerCase().replaceAll("[^a-z]", "").replaceAll("(.)(?=.*\\1)", "").length() == 26){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
        src.close();

    }
}
