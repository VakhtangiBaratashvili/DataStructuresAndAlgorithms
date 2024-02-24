package algorithms.search.binary.recursion;

public class BinarySearchRecursive {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 8, 10, 17, 25};
        int target = 8;
        int result = binarySearch(arr, target, 0, arr.length - 1);
        System.out.println("Index of " + target + ": " + result);
    }

    public static int binarySearch(int[] arr, int target, int low, int high) {
        int mid = (high + low) / 2;

        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] > target) {
            return binarySearch(arr, target,low, mid - 1);
        }
        else {
            return binarySearch(arr, target, mid + 1, high);
        }
    }
}
