// smallest number greater than or == target

public class BinarySearch {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] arr = {1,3,5,7,9,23};
        int target = 23;
    }

    static void ceiling(int [] arr, int target) {
        if(arr.length == 0) {
            return -1;
        }

        int start = 0;
        int end = arr.length - 1;

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

        return start;

    }
}
