class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] arr = new int[n * 2];
        int i = 0;
        int j = i + n;
        int z = 0;
        while(i < n) {
            arr[z] = nums[i];
            arr[z + 1] = nums[j];
            i++;
            j++;
            z = z + 2;
        }
        return arr;
    }
}