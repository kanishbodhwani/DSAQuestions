// Peak Index in a Mountain Array == bitonic array 

// https://leetcode.com/problems/peak-index-in-a-mountain-array/description/


public class MountainArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] arr = {1,2,3,4,5,6,4,3,2};
        // target == peak
        
    }

    static void peakIndexMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while(start < end) {
            int mid = start + (end - start) / 2;
            if(arr[mid] < arr[mid + 1]) {
                // ascending 
                start = mid + 1;
            } else {
                // decending
                end = mid;
            }
        }

        return start; // or end cause both points to the same number

    }


}
