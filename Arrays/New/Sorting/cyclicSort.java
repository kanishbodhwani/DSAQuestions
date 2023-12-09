// Cyclic Sort 
// Swap with indexing == check, swap , move
//# When given range of numbers [1, N] then use cyclic sort 
// O(n) // constant space complexity

public class CyclicSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] arr = {3,5,1,2,4}; // array should be continous
        cyclicSort(arr);
    }

    static void cyclicSort(int[] arr) {
        int i = 0;
        while(i < arr.length) {
            int correct = arr[i] - 1;
            if(arr[correct] != arr[i]) {
                swap(arr, i , correct);
            } else {
                i++;
            }
        }
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
