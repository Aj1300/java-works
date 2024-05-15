import java.io.*;
import java.util.*;

public class TransposeOfMatrix {
    public static void main(String[] args) {

        int r, c;
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        r = scan.nextInt();
        System.out.print("Enter the number of columns: ");
        c = scan.nextInt();

        int matrix[][] = new int[r][c];
        int transpose[][] = new int[r][c];
        System.out.println("Enter the elements of the matrix:");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++)
                matrix[i][j] = scan.nextInt();
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++)
                transpose[j][i] = matrix[i][j];
        }

        System.out.println("Original Matrix:");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++)
                System.out.print("\t" + matrix[i][j]);

            System.out.println();
        }

        System.out.println("Transpose Matrix:");
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                System.out.print("\t" + transpose[i][j]);
            }
            System.out.println();
        }

    }
}
