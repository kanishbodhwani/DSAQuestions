// Find position of an element in a sorted array of infinite numbers
// gfg

public class InfniteSortedArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] arr = {1,3,5,7,9,23,45,78,90,100, 234, 567};
        int target = 23;
    }

    static void ans(int[] arr, int target) {
        int start = 0;
        int end = 1;

        while(target > arr[end]) {
            int temp = end + 1;
            // end = 1 + 2 * content box
            end = end + (end - start + 1) * 2;
            start = temp;
        }

        return binarySearch(arr, target, start, end);
    }

    static void binarySearch(int [] arr, int target, int start, int end) {
        if(arr.length == 0) {
            return -1;
        }

        while(start <= end) {
            int mid = start + (end - start) / 2;

            if(target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;

    }
}
