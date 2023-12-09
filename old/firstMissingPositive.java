class Solution {
    public int firstMissingPositive(int[] nums) {
        return cycle(nums); 
    }
    
    int cycle(int[] arr) {
        int i = 0;
        while(i < arr.length) {
            int correctIndex = arr[i] - 1;
            if(arr[i] > 0 && arr[i] <= arr.length && arr[i] != arr[correctIndex]) {
                swap(arr, i , correctIndex);
            } else {
                i++;
            }
        }
        // search for first missing number 
        for(int index = 0; index < arr.length; index++) {
            if(arr[index] != index + 1) {
                return index + 1;
            } 
        }
        return arr.length + 1;
    }
    
    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    } 
}