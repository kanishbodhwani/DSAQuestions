class Solution {
    public static void main(String[] args) {
        int[] arr = {2,4,6,7,8,10,23,32};
        [14,16,17,18] target = 15
        [s , m, e, e]
    }
    
    static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
            
        while(start <= end) {
            int mid = start + (end - start) / 2;
            
            if(target > arr[mid]) {
                start = mid + 1;
            } else if (target < arr[mid]){
                end = mid - 1;    
            } else {
                return mid;
            }
            
        }
        
        return start;
    }
   
}