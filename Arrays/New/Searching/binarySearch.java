public class BinarySearch {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] arr = {1,3,5,7,9,23};
        int target = 23;
    }

    static void binarySearch(int[] arr, int target) {
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

        return -1;

    }

    // order agnostic binary search

    static void oABinarySearch(int[] arr, int target) {
        if(arr.length == 0) {
            return -1;
        }

        int start = 0;
        int end = arr.length - 1;

        // find out whether array is acending or decending order
        boolean isAsc = arr[start] < arr[end];

        while(start <= end){
           int mid = start + (end - start) / 2;

            if(arr[mid] == target){
                return mid;
            }

            if(isAsc) {
                if(target < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if(target > arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }

        return -1;

    }
}
