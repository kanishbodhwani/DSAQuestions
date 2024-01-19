// Find All Numbers Disappeared in an Array
// Given an array nums of n integers where nums[i] is in the range [1, n], 
// return an array of all the integers in the range [1, n] that do not appear in nums.

public class DissapearArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] arr = {4,3,2,7,8,2,3,1};
        // [5,6]
        dissapearArray(arr);
    }

    static void dissapearArray(int[] arr) {
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
                nums.add(i + 1);
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
