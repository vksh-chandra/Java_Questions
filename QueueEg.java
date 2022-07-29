public class QueueEg {
    int array[];
    int capacity;
    int front, rare;

    QueueEg(int size){
        capacity = size;
        array = new int[size];
        front = -1;
        rare = -1;
    }

    public boolean isFull(){
        if(front == 0 && rare == array.length-1){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean isEmpty(){
        if(front == -1){
            return true;
        }
        else{
            return false;
        }
    }

    public void enQueue(int element){
        if(isFull()){
            System.out.println("Queue si full");
        } else{
            if(front == -1){
                front =0;
            }
            
            array[++rare] = element; 
        }
    }

    public int deQueue(){
        int element;
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        else{
            element = array[front];

            if(front >= rare){
                front = -1;
                rare = -1;
            }
            else{
                front++;
            }
            return element;
        }
    }

    public void displayQueue(){
        if(isEmpty()){
            System.out.println("Queue is empty.");
        }
        else{
            for(int i=front; i<=rare; i++){
                System.out.println(array[i]);
            }
        }
    }

    public static void main(String[] args) {
        QueueEg queue = new QueueEg(5);

        queue.enQueue(5);
        queue.enQueue(6);
        queue.enQueue(7);
        queue.enQueue(8);
        queue.enQueue(9);

        queue.displayQueue();

        queue.deQueue();
        queue.deQueue();
        System.out.println("After DeQueue: ");
        queue.displayQueue();

    }

}
