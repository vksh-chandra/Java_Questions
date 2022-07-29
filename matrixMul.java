import java.util.*;
public class matrixMul {
    public static void main(String[] args) {
        int r1, r2, c1, c2;
        Scanner src = new Scanner(System.in);
        System.out.println("Enter no. of row for frst matrix: ");
        r1 = src.nextInt();
        System.out.println("Enter no. of column for frst matrix: ");
        c1 = src.nextInt();
        System.out.println("Enter no. of row for 2nd matrix: ");
        r2 = src.nextInt();
        System.out.println("Enter no. of column for frst matrix: ");
        c2 = src.nextInt();

        if(c1 != r2)
        {
            System.out.println("Multiplication is not possible: ");
            System.exit(0);
        }
            

        int[][] a = new int[r1][c1];
        int[][] b = new int[r2][c2];
        System.out.println("Enter element for "+ r1 +" row " + c1+ " col of first matrix: ");
        for(int i=0; i<r1; i++)
        {
            for(int j=0; j<c1; j++)
            {
                a[i][j] = src.nextInt();
            }
        }

        System.out.println("Enter element for "+ r2 +" row " + c2+ " col of 2nd matrix: ");
        for(int i=0; i<r2; i++)
        {
            for(int j=0; j<c2; j++)
            {
                b[i][j] = src.nextInt();
            }
        }

        System.out.println("A = " +Arrays.deepToString(a));
        System.out.println("B = "+Arrays.deepToString(b));



        int[][] c = new int[r1][c2];
        for(int i=0; i<r1;i++)
        {
            for(int j=0; j<c2; j++){
                for(int k=0; k<c1; k++){
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        System.out.println("Matrix after multiplication is: ");
        /*for(int[] i: c){
            for(int j : i){
                System.out.println(j);
            }
        } */

        System.out.println(Arrays.deepToString(c));

        src.close();

    }
}
