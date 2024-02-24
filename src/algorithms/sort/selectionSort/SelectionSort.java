package algorithms.sort.selectionSort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {6, 7, 3, 14, 2, 7, 10, 1, 13};
        System.out.println("Unsorted Array: " + Arrays.toString(arr));
        selectionSort(arr);
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int indexOfMin = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    indexOfMin = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[indexOfMin];
            arr[indexOfMin] = temp;
        }
    }
}
