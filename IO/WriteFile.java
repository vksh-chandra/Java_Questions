package IO;
import java.io.*;

public class WriteFile {
    public static void main(String[] args) {
        String str = "I am going to written inside test1";
        try{
            FileWriter output = new FileWriter("test1.txt");
            output.write(str);
            System.out.println("Data is written");
            output.close();
        }catch(Exception e){
            e.getStackTrace();
        }
    }
}
