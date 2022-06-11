 class Solution {
    public int search(int[] nums, int target) {
        int pivot = findPivot(nums);
        if(pivot == -1) {
            // just do normal binary search
            return binarySearch(nums, target, 0, nums.length - 1);
        }
        if(nums[pivot] == target) {
            return pivot;
        } else if(target >= nums[0]) {
            return binarySearch(nums, target, 0, pivot-1);
        } else {
            return binarySearch(nums, target, pivot+1, nums.length - 1);
        }
    }
    
    int findPivot(int[] arr) {
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
            if(arr[mid] <= arr[start]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            } 
        }
        return -1;
    }
    
    int findPivotWithDuplicates(int[] arr) {
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
                
                // Note: What if these elemets at start and end were the pivot
                // check if start is pivot
                if(arr[start] > arr[start + 1]) {
                    // start is pivot
                    return start;
                }
                start++;
                
                if(arr[end] < arr[end - 1]) {
                    // end - 1 is pivot
                    return end - 1;
                }
                end--;
                
            } else if(arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end])) {
                start = mid + 1
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
     
     
    int binarySearch(int[] arr, int target, int start, int end) {
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(target < arr[mid]) {
                end = mid - 1; 
            } else if(target > arr[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1; 
    }
}