import java.util.*;

public class OddEvenSort {
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        int[] array = new int[100];
        int x=0;
        while(src.hasNextInt()){
            array[x++]= src.nextInt();
        }

        int[] a = new int[x];
        for(int i=0; i<x;i++){
            a[i] = array[i];
        }
        Arrays.sort(a);
        int j=0;
        for(int i=0; i<a.length; i++){
            if(a[i]%2==0 && j%2==0){
                System.out.print(a[i]+" ");
                j++;
            }
            else if(a[i]%2==0 && j%2!=0){
                System.out.print("X "+a[i]+" ");
                j+=2;
            }
            else if(a[i]%2 !=0 && j%2!=0){
                System.out.print(a[i]+" ");
                j++;
            }
            else if(a[i]%2!=0 && j%2==0){
                System.out.print("X "+a[i]+" ");
                j +=2;
            }
        }
        src.close();

    }
}
