class Solution {
    public int rotationCounInRotatedArray(int[] arr) {
        int peak = peakElementInRotatedArray(arr);
        return pivot + 1;
    }
    
    int peakElementInRotatedArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        
        while(start < end) {
            // 4 cases
            if(arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if(arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }
            if(arr[start] >= arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1
            }
        }
        return start;
         
    }
}
