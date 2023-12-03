import java.util.Random;
import java.util.Scanner;

public class practical1 {

    public static void main(String[] args) {
        Scanner pw = new Scanner(System.in);
        System.out.print("Enter the number of inputs to be stored = ");
        long n = pw.nextLong();
        pw.close();
        long start = System.currentTimeMillis();

        long[] arr1 = new long[(int) n];

        for (int i = 0; i < n; i++) {
            arr1[i] = i;
        }

        for (int j = 0; j < n - 1; j++) {
            if (arr1[j] > arr1[j + 1]) {
                long temp = arr1[j];
                arr1[j] = arr1[j + 1];
                arr1[j + 1] = temp;
            }
        }
        long end = System.currentTimeMillis();

        long elapsed = end - start;
        
        // System.out.println("Sorted array:");
        // printArray(arr1);

        System.out.println("Elapsed time (in milliseconds): " + elapsed);
    }

    public static void printArray(long[] arr) {
        for (long num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
