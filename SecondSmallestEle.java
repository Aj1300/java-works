import java.util.*;
public class SecondSmallestEle {
    private static int[] sort(int array[], int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n;
        System.out.print("Enter the size of the array: ");
        n = scan.nextInt();
        System.out.println("Enter " + n + " elements: ");
        int array[] = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scan.nextInt();
        }
        array = sort(array, n);
        System.out.println("Second Smallest element is " + array[1]);
    }
}
