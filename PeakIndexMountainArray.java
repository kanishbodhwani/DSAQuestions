// Mountain array means increasing then decreasing 
// Also called Bitonic array
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        
        while(start < end) {
            int mid = start + (end - start) / 2;
            if(arr[mid] > arr[mid + 1]) {
                // dec part 
                // this may be the ans, but look left
                end = mid;
            } else {
                // asc part
                start = mid + 1;
            }
        } 
        return start; // or return end as both are equal
    }
    
}