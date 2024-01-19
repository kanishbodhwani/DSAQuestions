// Find the Duplicate Number
// https://leetcode.com/problems/find-the-duplicate-number/description/
/* Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
There is only one repeated number in nums, return this repeated number.
You must solve the problem without modifying the array nums and uses only constant extra space. */



public class DuplicateNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] arr = {1,3,4,2,2};
        // 2
        duplicateNumber(arr);
    }

    static void duplicateNumber(int[] arr) {
        int i = 0;
        while(i < arr.length) {
            if(arr[i] != i + 1) {
                int correct = arr[i] - 1;
                if(arr[i] != arr[correct]) {
                    swap(arr,i,correct);
                } else {
                    return arr[i];
                }
            } else {
                i++;
            }
        }

        return -1;
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
