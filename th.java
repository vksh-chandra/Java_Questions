import java.util.*;
import java.lang.*;

class myThread1 extends Thread{

    @Override
    public void run(){
        int i=0;
        while(i<10){
            try{
                Thread.sleep(500);
            }catch(Exception e){
                System.out.println(e);
            }

            System.out.println("Thread is running\n");
            System.out.println("I am happy\n");
            i++;
        }
    }
}

class myThread2 extends Thread{
    @Override
    public void run(){
        int i=0;
        while(i<10){
            System.out.println("Thread2 is running\n");
            System.out.println("I am run\n");
            i++;
        }
    }
}

public class th {
    public static void main(String[] args) {
        myThread1 t1 = new myThread1();
        myThread2 t2 = new myThread2();
        t1.start();
        try{
            t1.join();
        }catch(Exception e){
            System.out.println(e);
        }

        t2.start();
    }
}
