// First Missing Positive
// https://leetcode.com/problems/first-missing-positive/description/
// Given an unsorted integer array nums, return the smallest missing positive integer.


public class FirstMissingPositive {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] arr = [1,2,0];
        // 3
        firstMissingPositive(arr);
    }

    public int firstMissingPositive(int[] arr) {
        int i = 0;
        while(i < arr.length) {
            int correct = arr[i] - 1;
            if(arr[i] > 0 && arr[i] <= arr.length && arr[i] != arr[correct]) {
                swap(arr, arr[i], arr[correct]);
            } else {
                i++;
            }
        }

        // search for first missing number
        for(int i: arr) {
            if(arr[i] != i + 1) {
                return i + 1;
            }
        }

        return arr.length + 1;
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}