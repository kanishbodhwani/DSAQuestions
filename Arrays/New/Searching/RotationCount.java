// Rotation Count
// pivot + 1;

public class RotationCount {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = {9,23,1,3,5,7};

        int pivot = findPivot(arr);
        return pivot + 1;
    }

    static int findPivot(int[] nums) {
       int start = 0;
       int end = arr.length - 1;

        while(start <= end) {
            int mid = start = (end - start) / 2;

            if(mid < end && arr[mid] > arr[mid + 1]) { // for not going out of bounds use mid < end 
                return mid;
            } else if(mid > start && arr[mid] < arr[mid + 1]) {
                return mid - 1;
            } else if(arr[mid] <= arr[start]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        return -1;
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

}