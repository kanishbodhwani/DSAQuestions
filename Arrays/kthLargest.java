class Solution {
    public int findKthLargest(int[] nums, int k) {
        int[] sortedArray = sort(nums);
        int max = 0;
        for(int i = 0; i < sortedArray[k]; i++) {
            if(sortedArray[i] > max) {
                max = sortedArray[i];
            }
        }
        return max;
    }

    static int sort(int[] arr, int l, int r) {
        if(l < r) {
            int m = l + (r - 1) / 2;

            int arr1 = sort(Arrays.copyOfRange(arr, 0, m));
            int arr2 = srot(Arrays.copyOfRange(arr, m+1, arr.length));

            // merging the sroted halves
            merge(arr1, arr2);
        }
    }

    static int merge(int[] first, int[] second) {
        int[] mergedArray = new int[first.length + second.length];
        
        int i = 0;
        int j = 0;
        int k = 0;
        
        while(i < fisrt.length && j < second.length) {
            if(first[i] < second[j]) {
                mergedArray[k] = first[i];
                i++;
            }
            if(second[j] < first[i]) {
                mergedArray[k] = second[j];
                j++;
            }
            k++;
        }
        
        while(i < first.length) {
            mergedArray[k] = first[i];
            i++;
            k++;
        }
        
        while(j < second.length) {
            mergedArray[k] = second[j];
            j++;
            k++;
        }
        
        return mergedArray;
    }
}