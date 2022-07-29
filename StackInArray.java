import java.util.*;

class stackArray{
    int array[];
    int size;
    int top1, top2;
    public stackArray(int size){
        array = new int[size];
        this.size = size;
        top1 = -1;
        top2 = size;
    }
    public void push1(int n){
        if(top1+1 == top2){
            System.out.println("Stack Overflow");
            System.exit(-1);
        }
        array[++top1] = n;
    }
    public void push2(int n){
        if(top1+1==top2){
            System.out.println("Stack Overflow");
            System.exit(-1);
        }
        array[--top2] = n;
    }
    public int pop1(){
        if(top1==-1){
            System.out.println("Stack underflow");
            System.exit(-1);
        }
        int top = array[top1--];
        return top;
    }

    public int pop2(){
        if(top2==size){
            System.out.println("Stack underflow");
            System.exit(-1);
        }
        int top = array[top2++];
        return top;
    }
}

public class StackInArray {
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        System.out.println("Enter size of an array: ");
        int n = src.nextInt();
        stackArray stack = new stackArray(n);

        int i=1;
        while(i ==1){
            System.out.println("Select Operation: ");
            System.out.println("1. Push1 2. Push2 3. Pop1 4. Pop2");
            int x = src.nextInt();
            switch(x){
                case 1: System.out.println("Enter element to Push1: ");
                        int val1 = src.nextInt();
                        stack.push1(val1);
                        break;
                case 2: System.out.println("Enter element to Push2: ");
                        int val2 = src.nextInt();
                        stack.push2(val2);
                        break;
                case 3: 
                        int m1 = stack.pop1();
                        System.out.println("Poped from frst stack, element is: "+m1);
                        break;
                case 4: 
                        int m2 = stack.pop2();
                        System.out.println("Poped from frst stack, element is: "+m2);
                        break;
            }
            System.out.println("DO YOU WANT TO CONTINUE Press-1 or 0");
            i = src.nextInt();
        }

        src.close();
    }
}
