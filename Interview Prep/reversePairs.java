class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    public int merge(int[] nums, int left, int mid, int right) {
        int count = 0;
        int j = mid+1;
        for(int i = left; i <= mid; i++) {
            if(j <= right && nums[i] > 2 * (long) nums[j]) {
                j++;
            }
            count += (j - (mid+1));
        }
        
        ArrayList<Integer> temp = new ArrayList<>();
        int low = left; 
        int high = mid+1;
        while(low <= mid && high <= right) {
            if(nums[low] <= nums[high]) {
                temp.add(nums[low++]);
            } else {
                temp.add(nums[high++]);
            }
        }
        
        while(low <= mid){
            temp.add(nums[low++]);
        }
        while(high <= right) {
            temp.add(nums[high++]);
        }
        
        for(int i = left; i <= right; i++){
            nums[i] = temp.get(i - left);
        }
        return count;
    }
    
    
    public int mergeSort(int[] nums, int first, int last){
        if(first >= last) {
            return 0;
        }
        // for(int i = 0; i < nums.length; i++) {
        //     if(nums[i] < 0) {
        //         nums[i] = nums[i] * (-1);
        //     }
        // }
        int mid = (first + last) / 2;
        int cnt = mergeSort(nums, first, mid);
        cnt += mergeSort(nums, mid+1, last);
        cnt += merge(nums, first, mid, last);
        return cnt;
    } 
}