package IO;

import java.io.*;
public class ReadFile {
    public static void main(String[] args) {
        char[] array = new char[100];
        try{
            FileReader input = new FileReader("test1.txt");
            input.read(array);
            System.out.println(array);
            input.close();
        }catch(Exception e){
            e.getStackTrace();
        }
    }
}
