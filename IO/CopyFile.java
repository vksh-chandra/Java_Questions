package IO;
import java.io.*;
public class CopyFile {
    public static void main(String[] args) {
        byte[] array = new byte[100];
        try{
            FileInputStream srcFile = new FileInputStream("test1.txt");
            FileOutputStream destFile = new FileOutputStream("copytst1.txt");

            srcFile.read(array);
            destFile.write(array);
            System.out.println("Copied succesfully");
            srcFile.close();;
            destFile.close();
        }catch(Exception e){
            e.getStackTrace();
        }
    }
}
