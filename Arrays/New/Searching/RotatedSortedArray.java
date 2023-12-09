// Search in Rotated Sorted Array
//  trick - find pivot element 
// https://leetcode.com/problems/search-in-rotated-sorted-array/description/


public class RotatedSortedArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] arr = {9,23,1,3,5,7};
        int target = 23;
    }

    static int search(int[] nums, int target, int start, int end) {
        int pivot = findPivot(nums);

        if(pivot == -1) {
            return binarySearch(nums, target, 0, nums.length - 1);
        }

        if(nums[pivot] == target) {
            return pivot;
        }

        if(target >= nums[0]) { // target > start
            return binarySearch(nums, target, 0, pivot - 1);
        }

        return binarySearch(nums, target, pivot + 1, nums.length - 1);
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

    // with duplicates value 
    // [2,5,2,2,2]

    static int findPivotWithDuplicates(int[] nums) {
       int start = 0;
       int end = arr.length - 1;

        while(start <= end) {
            int mid = start = (end - start) / 2;

            if(mid < end && arr[mid] > arr[mid + 1]) { // for not going out of bounds use mid < end 
                return mid;
            }

            if(mid > start && arr[mid] < arr[mid + 1]) {
                return mid - 1;
            }

            // if elements at middle, start and end are equal then skip duplicates
            if(arr[mid] == arr[start] && arr[mid] == arr[end]) {
                // skip the duplicates
                // NOTE: Check if the elements start or end were pivot
                
                // check if start is pivot
                if(arr[start] > arr[start + 1]) {
                    return start;
                }
                start++;

                // check if end is pivot 
                if(arr[end] < arr[end - 1]) {
                    return end - 1;
                }
                end--;
            } else if (arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end])) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        return -1;
    }

}