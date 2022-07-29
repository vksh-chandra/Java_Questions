import java.util.*;
public class StackBalanceExpre {
    public static boolean balanceExpression(String s){
        if(s.length()%2==1){
            return false;
        }
        char[] ch = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<ch.length;i++){
            if(ch[i]=='{'||ch[i]=='['||ch[i]=='('){
                stack.push(ch[i]);
            }
            if(ch[i]=='}'||ch[i]==']'||ch[i]==')'){
                if(stack.isEmpty()){
                    return false;
                }
                char c = stack.pop();
                if((ch[i]=='}' && c!='{') || (ch[i]==']' && c !='[') || (ch[i]==')' && c!='(')){
                    return false;
                }
            }
        }
        return stack.isEmpty();

    }
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        System.out.println("Enter bracket: ");
        String str = src.next();
        boolean val = balanceExpression(str);
        System.out.println(val);

        src.close();
    }
}
