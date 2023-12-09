// Insertion sort
// insert the element at the correct index in lhs in each step

// why? 
// number of steps are reduced as compared to bubble sort 
// stable 
// used for smaller values of n , works good when array is partially sorted
// Takes part in hybrid sorting algorithms

// complexity O(n2)

public class InsertionSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] arr = {2,56,65,34,54,20};
        selectionSort(arr);
    }

    static void insertionSort(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++) { // < not <= if this then it will be <= i - 2 for not out of bounds
            for(int j = i + 1; j > 0; j++) {
                if(arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
