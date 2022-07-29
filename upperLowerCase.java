import java.util.*;
public class upperLowerCase {
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);

        String str = src.nextLine();
        int upper =0;
        int lower =0;
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch >= 'A' && ch <= 'Z'){
                upper++;
            }
            else{
                lower++;
            }
        }
        if(lower>= upper)
        {
            str = str.toLowerCase();
        }
        else{
            str = str.toUpperCase();
        }
        System.out.println(str);
        src.close();

    }
}
