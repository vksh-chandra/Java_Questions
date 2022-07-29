package Stack;
import java.util.*;

public class ArrayL {
    public static void main(String[] args) {
        ArrayList<String> animals = new ArrayList<>();
        animals.add("Tiger");
        animals.add("Lion");
        animals.add("Deer");

        // List<String> birds = new ArrayList<>();
        // birds.add("crow");
        // birds.add("sparrow");
        // birds.add("pigeon");

        //ARRAYLIST TO ARRAY
        String[] str = new String[animals.size()];
        animals.toArray(str);
        System.out.println("ArraysList: "+animals);
        System.out.println("Array: ");
        for(String s : str){
            System.out.println(s);
        }

        //ARRAY TO ARRAY LIST
        ArrayList<String> newArray = new ArrayList<>(Arrays.asList(str));
        System.out.println(newArray);
       
        
    }
}
