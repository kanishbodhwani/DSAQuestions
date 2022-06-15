public class RotatedBinarySearch {
    public static void main(String[] args) {
        int[] nums = {1,0,1,1,1};
        int target = 0;
        int pivot = findPivotWithDuplicates(nums);
        boolean ans1 = binarySearch(nums, target, 0, pivot);
        if(ans1) {
            System.out.println(ans1);
        }
        boolean ans2 = binarySearch(nums, target, pivot + 1, nums.length - 1);
        System.out.println(ans2);
    }

    static int findPivotWithDuplicates(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while(start <= end) {
            int mid = start + (end - start) / 2;
            // 4 cases
            if(mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if(mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }
            // if elements at middle, start and end are equal then skip duplicates
            if(arr[mid] == arr[start] && arr[mid] == arr[end]) {
                // skip the duplicates

                // Note: What if these elements at start and end were the pivot
                // check if start is pivot
                if(arr.length > 1 && arr[start] > arr[start + 1]) {
                    // start is pivot
                    return start;
                }
                start++;

                if(arr.length > 1 && arr[end] < arr[end - 1]) {
                    // end - 1 is pivot
                    return end - 1;
                }
                end--;

            } else if(arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end])) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }


    static boolean binarySearch(int[] arr, int target, int start, int end) {
        while(start <= end) {
            int mid = start + (end - start) / 2;

            if(arr.length > 1) {
                if(target > arr[mid]) {
                    start = mid + 1;
                } else if (target < arr[mid]) {
                    end = mid - 1;
                } else {
                    return true;
                }
            } else {
                return arr[0] == target;
            }
        }
        return false;
    }

}

