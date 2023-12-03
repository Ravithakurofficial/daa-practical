import java.util.Scanner;

public class Pl2pt3 {
    public static void main(String[] args) {
        Scanner pw = new Scanner(System.in);

        System.out.print("Enter The length = ");
        int a = pw.nextInt();

        int[] arr1 = new int[a];

        for (int i = a, j = 0; i > 0; i--, j++) {
            arr1[j] = i;
        }
        long start = System.currentTimeMillis();
        for (int i = 0; i < a - 1; i++) {
            for (int j = 0; j < a - i - 1; j++) {
                if (arr1[j] > arr1[j + 1]) {
                    int temp = arr1[j];
                    arr1[j] = arr1[j + 1];
                    arr1[j + 1] = temp;
                }
            }
        }
        long end = System.currentTimeMillis();

        long elapsed = end - start;

        System.out.println("Elapsed time (in milliseconds): " + elapsed);

        
    }
}
