//An array arr a mountain if the following properties hold:
//
//arr.length >= 3
//There exists some i with 0 < i < arr.length - 1 such that:
//arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
//arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
//Given a mountain array arr, return the index i such that arr[0] < arr[1] < ... < arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1].
//
//You must solve it in O(log(arr.length)) time complexity.


class Solution {
    public int findPeakElement(int[] arr) {
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