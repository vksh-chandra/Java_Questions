public class StackEg {
    int array[];
    int top;
    int capacity;

    StackEg(int size){
        array = new int[size];
        top =-1;
        capacity = size;
    }

    public void push(int data){
        if(isFull()){
            System.out.println("Stack overlfow");
            System.exit(1);
        }
        array[++top] = data;
    }

    public int pop(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            System.exit(1);
        }
        return array[top--];
    }

    public int getSize(){
        return top+1;
    }

    public boolean isFull(){
        return top == capacity-1;
    
    }
    public boolean isEmpty(){
        return top == -1;
    }

    public void printStack(){
        for(int i=0;i<=top;i++){
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) {
        StackEg stack = new StackEg(5);
        stack.push(5);
        stack.push(15);
        stack.push(25);
        stack.push(45);
        stack.push(33);
        System.out.println("Stack: ");
        stack.printStack();

        int x = stack.pop();
        int y = stack.pop();
        System.out.println("Stack After POP: "+ x+" "+y);
        stack.printStack();
    }

}
