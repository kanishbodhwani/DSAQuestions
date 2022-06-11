class Solution {
    public int splitArrayLargestSum(int[] nums, int m) {
        
    }
    
    int splitArray(int[] nums, int m) {
        int start = 0;
        int end = 0;
        
        for(int i = 0; i< nums.length; i++) {
            start = Math.max(start, nums[i]);
            end += nums[i];
        }
        
        // binary Search
        while(start < end) {
            // try for the middle as potentioal answer 
            int mid = start + (end - start) / 2
        
            // Calculate how many peices you can divide this in with max sum
            int sum = 0;
            int pieces = 1;
            for(int num: nums) {
                if(sum + num > mid) {
                    // You cannnot add this in subarray make new one
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
        return end;
    }
}