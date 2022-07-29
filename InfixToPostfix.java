import java.util.*;
public class InfixToPostfix {

    public static int precedence(char c){
        if(c=='*'|| c=='/'){
            return 3;
        }
        if(c=='+'|| c=='-'){
            return 4;
        }
        if(c=='&'){
            return 5;
        }
        if(c=='^'){
            return 6;
        }
        if(c=='|'){
            return 7;
        }
        return Integer.MAX_VALUE;
    }

    public static boolean operand(char c){
        if((c>='a' && c<='z')||(c>='A' && c<='Z')||(c>='0' && c<='9')){
            return true;
        }else{
            return false;
        }
    }

    public static String infixToPost(String str){
        String postfix ="";
        Stack<Character> stack = new Stack<>();

        char[] ch = new char[str.length()];
        ch = str.toCharArray();
        for(char c: ch){
            if(c=='('){
                stack.push(c);
            }
            else if(c==')'){
                while(stack.peek()!='('){
                    postfix += stack.pop();
                }
                stack.pop();
            }

            else if(operand(c)){
                postfix +=c;
            }

            else{
                while (!stack.isEmpty() && precedence(c)>=precedence(stack.peek())) {
                    postfix += stack.pop();
                }
                stack.push(c);
            }
        }

        while(!stack.isEmpty()){
            postfix +=stack.pop();
        }
        return postfix;

    }
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        System.out.println("Enter string to convert infix to postfix: ");
        String str = "Ax(BxC+DxE)+F";
        String postfix = infixToPost(str);
        System.out.println(postfix);
        src.close();

    }
}
