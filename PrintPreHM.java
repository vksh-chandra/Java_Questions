import java.util.*;

//print preorder using hashmap

public class PrintPreHM {
    static int postIdx;

    static void printPre(int[] in, int[] post, int start, int end, Stack<Integer> s, HashMap<Integer, Integer> map ){
        if(start>end)
            return;
        int val = post[postIdx];
        int inIdx = map.get(val);
        postIdx--;
        printPre(in, post, inIdx+1, end,s, map);
        printPre(in, post, start, inIdx-1,s, map);
        s.push(val);
    }

     static void printPreMain(int[] in, int[] post){
        int len = post.length;
        postIdx=len-1;
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> s = new Stack<>();

        for(int i=0;i<len;i++){
            map.put(in[i], i);
        }
        printPre(in, post, 0, len-1,s, map);

        while(!s.empty()){
            System.out.print(s.pop()+" ");
        }

     }
    public static void main(String[] args) {
        int in[] = { 4, 10, 12, 15, 18, 22, 24, 25, 31, 35, 44, 50, 66, 70, 90 };
        int post[] = { 4, 12, 10, 18, 24, 22, 15, 31, 44, 35, 66, 90, 70, 50, 25 };
        printPreMain(in, post);
    }
}
