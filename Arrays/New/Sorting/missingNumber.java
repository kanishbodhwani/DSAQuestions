// Missing number
// Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
// https://leetcode.com/problems/missing-number/description/

// range given means cyclic sort

// [1,2,0,4,5]
// [0,1,2,3,4,5]

public class MissingNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] arr = {3,1,2,4}; // array should be continous
        int n = 5
        missingNumber(arr, n);
    }

    static void missingNumber(int[] arr, int n) {
        int i = 0;
        while(i < arr.length) {
            int correct = arr[i];
            if(arr[i] < arr.length && arr[i] != arr[correct]) {
                swap(arr, arr[i], arr[correct]);
            } else {
                i++;
            }
        }

        // search for first missing number
        for(int i: arr) {
            if(arr[i] != i) {
                return i;
            }
        }

        // case 2 
        // when all are at the correct index, only num left is n
        return arr.length;
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
