package algorithms.search.binary.loop;


public class BinarySearchLoop {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 8, 10, 17, 25};
        int target = 4;
        int result = binarySearch(arr, target);
        System.out.println("Index of " + target + ": " + result);
    }

    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (high + low) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            else if (arr[mid] > target) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
