package algorithms.sort.quickSort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {6, 7, 3, 14, 2, 7, 10, 1, 13};
        System.out.println("Unsorted Array: " + Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int pivot = arr[high];
        int left = low;
        int right = high;
        while (left < right) {
            while (arr[left] <= pivot && left < right) {
                left++;
            }
            while (arr[right] >= pivot && left < right) {
                right--;
            }
            swap(arr, left, right);
        }
        swap(arr, left, high);

        quickSort(arr, low, left - 1);
        quickSort(arr, left + 1, high);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
