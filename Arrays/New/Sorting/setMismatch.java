// Set Mismatch
// https://leetcode.com/problems/set-mismatch/description/
// You have a set of integers s, which originally contains all the numbers from 1 to n. 
// Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and loss of another number.

public class SetMismatch {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] arr = [1,2,2,4];
        // [2,3]
        findErrorNums(arr);
    }

    public int[] findErrorNums(int[] arr) {
        int i = 0;
        while(i < arr.length) {
            int correct = arr[i] - 1;
            if(arr[i] != arr[correct]) {
                swap(arr, arr[i], arr[correct]);
            } else {
                i++;
            }
        }

        for(int i: arr) {
            if(arr[i] != i + 1) {
                return new int[]{arr[i], i + 1}
            }
        }

        return new int[]{-1,-1}
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
