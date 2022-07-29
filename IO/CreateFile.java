package IO;

import java.io.*;

public class CreateFile {
    public static void main(String[] args) {
        File file = new File("test1.txt");
        try{
            boolean val = file.createNewFile();
            if(val){
                System.out.println("File is created");
            }else{
                System.out.println("File Already exist");
            }
        }catch(Exception e) {
            e.getStackTrace();
        }
    }
}
