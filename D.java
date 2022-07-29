import java.util.*;
import java.io.*;

public class D {

    public static void main(String[] args) throws java.lang.Exception {
        Scanner src = new Scanner(System.in);
        int n = src.nextInt();
        int[][] arr = new int[n][2];
        for(int i=0; i<n; i++){
            arr[i][0] = src.nextInt();
            arr[i][1] = src.nextInt();
        }
        getArr(arr);
        //System.out.println(getArr(arr));
        src.close();

    }
    public static void getArr(int[][] arr){
        int len = arr.length;
        HashMap<Integer, Integer> win = new HashMap<>();
        HashMap<Integer, Integer> loose = new HashMap<>();

        for(int i=0; i<len; i++){
            win.put(arr[i][0], win.getOrDefault(arr[i][0], 0)+1);
            loose.put(arr[i][1], loose.getOrDefault(arr[i][1], 0)+1);
        }

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> bwin = new ArrayList<>();
        List<Integer> bloose = new ArrayList<>();

        for(int key: win.keySet()){
            if(loose.containsKey(key)==false){
                bwin.add(key);
            }
        }

        for(int key: loose.keySet()){
            if(loose.get(key)==1){
                bloose.add(key);
            }
        }

        Collections.sort(bwin);
        Collections.sort(bloose);
        res.add(bwin);
        res.add(bloose);

        System.out.println(res.get(0));
        System.out.println(res.get(1));
    }

}