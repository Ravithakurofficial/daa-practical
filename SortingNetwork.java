public class SortingNetwork {

    // Comparator function to compare and swap two elements
    private static void compareAndSwap(int[] array, int i, int j) {
        if (array[i] > array[j]) {
            // Swap the elements
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    // Sorting network using bitonic merge
    private static void bitonicMerge(int[] array, int low, int count, boolean direction) {
        if (count > 1) {
            int k = count / 2;
            for (int i = low; i < low + k; i++) {
                compareAndSwap(array, i, i + k);
            }

            bitonicMerge(array, low, k, direction);
            bitonicMerge(array, low + k, k, direction);
        }
    }

    // Bitonic sort recursively
    private static void bitonicSort(int[] array, int low, int count, boolean direction) {
        if (count > 1) {
            int k = count / 2;

            // Sort in ascending order
            bitonicSort(array, low, k, true);

            // Sort in descending order
            bitonicSort(array, low + k, k, false);

            // Merge the entire sequence
            bitonicMerge(array, low, count, direction);
        }
    }

    // Public method to perform bitonic sort
    public static void sort(int[] array) {
        int n = array.length;
        boolean ascending = true; // Set to true for ascending order

        bitonicSort(array, 0, n, ascending);
    }

    // Main method to test the sorting network
    public static void main(String[] args) {
        int[] array = {5, 12, 9, 1, 7, 3, 8, 10, 2, 6, 4, 11};
        
        System.out.println("Original Array:");
        printArray(array);

        // Perform sorting
        sort(array);

        System.out.println("\nSorted Array:");
        printArray(array);
    }

    // Helper method to print an array
    private static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
