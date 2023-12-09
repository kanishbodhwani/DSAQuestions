// Find First and Last Position of Element in Sorted Array

// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/

// If target is not found in the array, return [-1, -1].

public class FirstAndLastPosition {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] nums = [5,7,7,8,8,10];
        int target = 8;
    }

    static int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        int startValue = search(nums, target, true);
        int endValue = search(nums, target, false);

        return [startValue, endValue];
    }

    static int search(int[] nums, int target, boolean findStartIndex) {
        int ans = -1;
        int start = 0;
        int end = arr.length - 1;

        while(start <= end) {
            int mid = start + (end - start) / 2;

            if(target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                // potential ans found
                ans = mid
                if(findStartIndex) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }

        return ans;
    }
}

