package IO;
import java.io.*;
public class ByteArrayStream {
    public static void main(String[] args) {
        byte[] array = {1,2,3,4,5,6,7};
        try{
            ByteArrayInputStream input = new ByteArrayInputStream(array);
            System.out.println("The array is: ");
            for(int i=0;i<array.length;i++){
                System.out.print(input.read()+" ");
            }
        }catch(Exception e){
            e.getStackTrace();
        }
    }
}
