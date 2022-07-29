public class Dequque {
    int array[];
    int size;
    int front, rear;
    public Dequque(int size){
        array = new int[size];
        this.size = size;
        front = -1;
        rear = -1;
    }

    boolean isEmpty(){
        if(front==-1 && rear ==-1){
            return true;
        }
        else{
            return false;
        }
    }

    boolean isFull(){
        if(front ==0 && rear == size-1){
            return true;
        }
        else if(front == rear+1){
            return true;
        }
        else{
            return false;
        }
    }

    void insertFront(int n){
        if(isFull()){
            System.out.println("Dqueue is Full");
            return;
        }
        else if(front == -1 && rear ==-1){
            front =0; rear =0;
        }
        else if(front==0){
            front = size-1;
            
        }
        else{
            front--;
        }
        array[front] =n;
    }

    void insertRear(int n){
        if(isFull()){
            System.out.println("Deque is full");
            return;
        }else if(front ==-1 && rear ==-1){
            front =0; rear =0;
        } else if(rear == size-1){
            rear = 0;
        }
        else{
            rear++;
        }
        array[rear] = n;
    }

    void deleteFront(){
        if(isEmpty()){
            System.out.println("Deque is empty");
            return;
        }
        else if(front == rear){
            front =-1;
            rear = -1;
        }
        else if(front==size-1){
            front = 0;
        }else{
            front++;
        }
    }

    void deleteRear(){
        if(isEmpty()){
            System.out.println("Deque is empty");
            return;
        }
        else if(front == rear){
            front =-1;
            rear =-1;
        } else if(rear ==0){
            rear = size-1;
        }else{
            rear--;
        }
    }

    // void displayDequeue(){
    //     if(isEmpty()){
    //         System.out.println("Dequeue is empty");
    //         return;
    //     }
    //     else{
    //         for(int i=0;i<array.length;i++){
    //             System.out.println(array[i]);
    //         }
    //     }
    // }
    int getFront(){
        if(isEmpty()){
            System.out.println("Empty Dequeue");
            return -1;
        }
        return array[front];
    }

    int getRear(){
        if(isEmpty()){
            System.out.println("Empty Dequeue");
            return -1;
        }
        return array[rear];
    }

    public static void main(String[] args) {
        Dequque d = new Dequque(5);
        d.insertFront(10);
        d.insertRear(80);
        d.insertFront(5);
        System.out.println("Front is: "+d.getFront());
        
        d.insertFront(4);
        d.insertRear(90);
        System.out.println("Rare is: "+d.getRear());
        
        // System.out.println("Dequeu is: ");
        // d.displayDequeue();

        d.deleteFront();
        d.deleteRear();
        System.out.println("Front is: "+d.getFront());
        System.out.println("Rare is: "+d.getRear());

        // SAME ISLIE AYA KUKI ARRAY MEIN TO ELEMENT HAI HII... BS FORNT OR RARE KA POSIOTION CHANGE HUA.
        //ALAG LANE K LIE ARRAYLIST USE KRO OR REMOVE METHOD USE KR K DKH SKHTE HAI....
        //System.out.println("Dequeu is after deletion: ");
        // d.displayDequeue();

    //     System.out.println("Insert element at rear end : 12 ");
    // d.insertRear(12);

    // System.out.println("insert element at rear end : 14 ");
    // d.insertRear(14);

    // System.out.println("get rear element : " + d.getRear());

    // d.deleteRear();
    // System.out.println("After delete rear element new rear become : " + d.getRear());

    // System.out.println("inserting element at front end");
    // d.insertFront(13);

    // System.out.println("get front element: " + d.getFront());

    // d.deleteFront();

    // System.out.println("After delete front element new front become : " + +d.getFront());
    }
}
