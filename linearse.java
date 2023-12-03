import java.util.Scanner;

public class linearse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        int[] arr = new int[size];

        // Populate the array with values from 0 to size-1
        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }

        System.out.print("Enter the value to search: ");
        int searchValue = scanner.nextInt();

        // Perform linear search
        int index = -1;  // Initialize index to -1, indicating not found

        for (int j = 0; j < size; j++) {
            if (searchValue == arr[j]) {
                index = j;
                break;  // Target found, exit the loop
            }
        }

        // Print the result
        if (index != -1) {
            System.out.println("Value found at index: " + index);
        } else {
            System.out.println("Value not found in the array.");
        }
    }
}
