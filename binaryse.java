import java.util.Scanner;

public class binaryse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the sorted array: ");
        int size = scanner.nextInt();
        int[] arr = new int[size];

        System.out.println("Enter sorted elements:");

        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }

        System.out.print("Enter the value to search: ");
        int searchValue = scanner.nextInt();

        int result = binarySearch(arr, searchValue);

        if (result != -1) {
            System.out.println("Value found at index: " + result);
        } else {
            System.out.println("Value not found in the array.");
        }
    }

    static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
}
