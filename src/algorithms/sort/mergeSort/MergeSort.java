package algorithms.sort.mergeSort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {6, 7, 3, 14, 2, 7, 10, 1, 13};
        System.out.println("Unsorted Array: " + Arrays.toString(arr));
        mergeSort(arr);
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr) {
        int length = arr.length;
        if (length < 2) {
            return;
        }
        int mid = length / 2;
        int[] leftArr = new int[mid];
        int[] rightArr = new int[length - mid];

        for (int i = 0; i < mid; i++) {
            leftArr[i] = arr[i];
        }
        for (int i = mid; i < length; i++) {
            rightArr[i - mid] = arr[i];
        }

        mergeSort(leftArr);
        mergeSort(rightArr);

        merge(arr, leftArr, rightArr);
    }

    private static void merge(int[] arr, int[] leftArr, int[] rightArr) {
        int leftLength = leftArr.length;
        int rightLength = rightArr.length;

        int i = 0, j = 0, k = 0;

        while (i < leftLength && j < rightLength) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < leftLength) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < rightLength) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }
}
