class Solution {
    public int missingNumber(int[] nums) {
        return cycle(nums);
    }
    
    int cycle(int[] arr) {
        int i = 0;
        while(i < arr.length) {
            int correctIndex = arr[i];
            if(arr[i] < arr.length && arr[i] != arr[correctIndex]) {
                swap(arr, i , correctIndex);
            } else {
                i++;
            }
        }
        // search for first missing number 
        for(int in = 0; in < arr.length; i++) {
            if(arr[in] != in) {
                return in;
            } 
        }
        return arr.length;
    }
    
    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}