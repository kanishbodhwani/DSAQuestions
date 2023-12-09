// Split Array Largest Sum

// https://leetcode.com/problems/split-array-largest-sum/description/

public class SplitArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = {9,23,1,3,5,7};

    }

    public int splitArrayLargestSum(int[] nums, int m) {
        int start = 0;
        int end = 0;

        // range
        for(int i = 0; i < nums.length; i++) {
            start = Math.max(start, nums[i]);
            end += nums[i];
        }

        // binary search
        while(start < end) {
            // try mid is the potential ans
            int mid = start + (end - start) / 2;

            // calculate how many pieces you can divide this in with this max sum = mid
            int sum = 0;
            int pieces = 1;

            for(int num: nums){
                if(sum + num > mid) {
                    sum = num;
                    pieces++;                    
                } else {
                    sum += num;
                }
            }

            if(pieces > m) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return start; // here start == end;
    }

}