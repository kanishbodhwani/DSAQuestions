// Find All Duplicates in an Array
// https://leetcode.com/problems/find-all-duplicates-in-an-array/description/
// Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer appears once or twice, return an array of all the integers that appears twice.

public class AllDuplicates {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] arr = [4,3,2,7,8,2,3,1];
        // [2,3]
        allDuplicates(arr);
    }

    public List<Integer> findDuplicates(int[] arr) {
        int i = 0;
        while(i < arr.length) {
            int correct = arr[i] - 1;
            if(arr[i] != arr[correct]) {
                swap(arr, arr[i], arr[correct]);
            } else {
                i++;
            }
        }

        List<Integer> nums = new ArrayList<>();
        for(int i: arr) {
            if(arr[i] != i + 1) {
                nums.add(arr[i]);
            }
        }
        return nums;
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
