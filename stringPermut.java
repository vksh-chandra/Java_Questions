public class stringPermut {

    public static void main(String[] args) {
        permutations("ABC", 0, 2);

    }
    static void permutations(String s, int l, int r){
        if(l==r){
            System.out.println(s);
            return;
        }
        for(int i=l;i<=r;i++)
        {
            System.out.println("Before interchange call: " +i);
            s = interChange(s,l,i);
            System.out.println("Before recursive call: " +i);
            permutations(s, l+1, r);
            System.out.println("After recursive call: " +i);
            s = interChange(s,l,i);
            System.out.println("After backtrack call: " +i);

        }
        
    }
    static String interChange(String s, int a, int b){
        char arr[] = s.toCharArray();
        char temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
        return String.valueOf(arr);
    }
}