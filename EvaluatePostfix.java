import java.util.Stack;
public class EvaluatePostfix {
    public static int evalPostfix(String s){

        Stack<Integer> stack = new Stack<>();
        
        for(char c: s.toCharArray()){

            if(Character.isDigit(c)){
                stack.push(c-'0');
            }
            else{
                int x = stack.pop();
                int y = stack.pop();

                if(c=='+'){
                    stack.push(x+y);
                }
                else if(c=='-'){
                    stack.push(y-x);
                }
                else if(c=='x'){
                    stack.push(y*x);
                }
                else if(c=='/'){
                    stack.push(y/x);
                }
            }
        }
        return stack.pop();
    }
    public static void main(String[] args) {
        String s = "138x+";
        System.out.println(evalPostfix(s));
    }
}
