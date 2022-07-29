import java.util.*;

public class CircularQueue {
    int array[];
    int capacity;
    int front, rare;
    public CircularQueue(int size){
        array = new int[size];
        capacity = size;
        front =-1;
        rare =-1;
    }

    boolean isFull(){
        if(front==0 && rare == array.length-1){
            return true;
        }
        else if(front == rare+1){
            return true;
        }
        else{
            return false;
        }
    }

    boolean isEmpty(){
        if(front==-1){
            return true;
        } else{
            return false;
        }
    }

    void enQueue(int n){
        if(isFull()){
            System.out.println("Queue is full");
        }
        else{
            if(front==-1)
                front =0;
            rare =(rare+1)%capacity;
            array[rare] = n;
        }
    }
    
    int deQueue(){
        int val;
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        else{
            val = array[front];
            if(front == rare){
                front =-1;
                rare = -1;
            }
            else{
                front = (front+1)%capacity;
            }   
            return val;
        }   
    }
    void display(){
        if(isEmpty()){
            System.out.println("Empty queue");
        }
        else{
            for(int i=0;i<array.length;i++){
                System.out.println(array[i]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        System.out.println("Enter size of Circular queue: ");
        int n = src.nextInt();
        CircularQueue cq = new CircularQueue(n);
        int i=1;
        while(i ==1){
            System.out.println("Select Operation: ");
            System.out.println("1. Enqueue 2. Dequeue 3. Display 4. exit");
            int x = src.nextInt();
            switch(x){
                case 1: System.out.println("Enter element to insert: ");
                        int val = src.nextInt();
                        cq.enQueue(val);
                        break;
                case 2: 
                        int m = cq.deQueue();
                        System.out.println("Dequeued element is: "+m);
                        break;
                case 3: cq.display();
                break;
            }
            System.out.println("DO YOU WANT TO CONTINUE Press-1 or 0");
            i = src.nextInt();
        }
        
        src.close();   
    }
}
