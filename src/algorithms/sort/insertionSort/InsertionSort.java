package algorithms.sort.insertionSort;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {6, 7, 3, 14, 2, 7, 10, 1, 13};
        System.out.println("Unsorted Array: " + Arrays.toString(arr));
        insertionSort(arr);
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > current) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = current;
        }
    }
}
