package Tree;
import java.util.HashMap;

public class PostorderHashMap {
    static int preIdx =0;
    static void printPostrder(int[] in, int[] pre, int start, int end, HashMap<Integer, Integer> map ){
        if(start>end)
            return;
        
        int index = map.get(pre[preIdx++]);

        //left subtree
        printPostrder(in, pre, start, index-1, map);
        //right subtree
        printPostrder(in, pre, index+1, end, map);
        System.out.print(in[index]+" ");

    }
    static void printPostrderMain(int[] in, int[] pre){
        int n = pre.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<pre.length;i++){
            map.put(in[i], i);
        }
        printPostrder(in, pre, 0, n-1, map);
    }
    public static void main(String[] args) {
        int in1[] = { 4, 2, 5, 1, 3, 6 };
        int pre[] = { 1, 2, 4, 5, 3, 6 };
        System.out.println("Postorder traversal " );
        printPostrderMain(in1, pre);
    }
}
