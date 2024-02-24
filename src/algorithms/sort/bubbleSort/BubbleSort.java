package algorithms.sort.bubbleSort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {6, 7, 3, 14, 2, 7, 10, 1, 13};
        System.out.println("Unsorted Array: " + Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
