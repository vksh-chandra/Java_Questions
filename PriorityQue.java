import java.util.*;
public class PriorityQue {
    void heapify(ArrayList<Integer> a, int i){
        int size = a.size();
        int largest = i;
        int l = 2*i+1;
        int r = 2*i+2;

        if(l<size && a.get(l)>a.get(largest)){
            largest = l;
        }
        if(r<size && a.get(r)>a.get(largest)){
            largest = r;
        }

        if(largest!=i){
            int temp = a.get(largest);
            a.set(largest, a.get(i));
            a.set(i, temp);

            heapify(a, largest);
        }
    }

    void insert(ArrayList<Integer> a, int num){
        int size = a.size();
        if(size==0){
            a.add(num);
        }
        else{
            a.add(num);
            for(int i=size/2-1; i>=0; i--){
                heapify(a, i);
            }
        }
    }

    void delete(ArrayList<Integer> a, int num){
        int size = a.size();
        int i;
        for(i=0;i<size;i++){
            if(num==a.get(i)){
                break;
            }
        }
        int temp = a.get(size-1);
        a.set(size-1, a.get(i));
        a.set(i, temp);
        a.remove(size-1);

        for(int j=size/2-1;j>=0;j--){
            heapify(a, j);
        }
    }

    void printQueue(ArrayList<Integer> a, int size){
        for(Integer i:a){
            System.out.println(i+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>();
        int size = array.size();
        PriorityQue p = new PriorityQue();
        p.insert(array, 11);
        p.insert(array, 17);
        p.insert(array, 15);
        p.insert(array, 23);
        p.insert(array, 20);
        p.insert(array, 16);
        p.insert(array, 17);
        p.insert(array, 25);
        
        System.out.println("Max Heap: ");
        p.printQueue(array, size);

        p.delete(array, 25);
        System.out.println("After Deleteing 4: ");
        p.printQueue(array, size);

    }
}
