package IO;
import java.io.*;
public class InputStream {
    public static void main(String[] args) {
        try{
            FileInputStream file = new FileInputStream("test1.txt");
            int i = file.read();
            while(i!=-1){
                System.out.print((char)i);
                i = file.read();
            }
            file.close();
        }catch(Exception e){
            e.getStackTrace();
        }
    }
}
