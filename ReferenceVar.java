public class ReferenceVar {
    int x = 10;
    int y = 20;
 
    int display(ReferenceVar A, ReferenceVar B)
    {
        //  Updating value using argument
        A.x = 95;
 
        System.out.println("x = " + x);
 
        System.out.println("y = " + y);
 
        return 0;
    }
}
 
class My1 {
    public static void main(String[] args)
    {
        ReferenceVar D1 = new ReferenceVar(); // point 1
        ReferenceVar C = new ReferenceVar(); // point 1
        ReferenceVar D = new ReferenceVar(); // point 1

 
        System.out.println(D1); // point 2
 
       // System.out.println(D1.display()); // point 3

        C.y = 55;
 
        C.display(C, D); // POINT 1
 
        D.display(C, D); 
    }
}
