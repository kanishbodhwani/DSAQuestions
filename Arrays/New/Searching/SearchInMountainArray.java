// Search target in a Mountain Array == bitonic array 

public class MountainArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] arr = {1,2,3,4,5,6,4,3,2};
        int target = 4;
        int ans;
        int peak = peakIndexMountainArray(arr);
        ans = oABinarySearch(arr, target, 0, peak);
        if(ans == -1) {
            ans = oABinarySearch(arr, target, peak, arr.length - 1);    
        }
        return ans;
    }

    static int peakIndexMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while(start < end) {
            int mid = start + (end - start) / 2;
            if(arr[mid] < arr[mid + 1]) {
                // ascending 
                start = mid + 1;
            } else {
                // decending
                end = mid;
            }
        }

        return start; // or end cause both points to the same number

    }

    static int oABinarySearch(int[] arr, int target, int start, int end) {
        if(arr.length == 0) {
            return -1;
        }

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
