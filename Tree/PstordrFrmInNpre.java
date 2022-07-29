package Tree;
import java.util.Arrays;

public class PstordrFrmInNpre {
    static int findRoot(int[] in, int x){
        
        for(int i=0;i<in.length;i++){
            if(in[i]==x){
                return i;
            }
        }
        return -1;
    }

    static void printPostOrder(int[] in, int[] pre, int n){
        int root = findRoot(in, pre[0]);

        //print left subtree
        if(root!=0){
            printPostOrder(in, Arrays.copyOfRange(pre, 1, n), root );
        }

        //right subtree
        if(root!=n-1){
            printPostOrder(Arrays.copyOfRange(in, root+1, n), Arrays.copyOfRange(pre, root+1, n), n-root-1);
        }

        System.out.print(pre[0]+" ");
    }
    public static void main(String[] args) {
        int in1[] = { 4, 2, 5, 1, 3, 6 };
        int pre[] = { 1, 2, 4, 5, 3, 6 };
        int n = in1.length;
        System.out.println("Postorder traversal " );
        printPostOrder(in1, pre, n);
    }
}
