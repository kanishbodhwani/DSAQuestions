// Complexity O(N2)

public class QuickSort {
    public static void main(String[] args) {
        // low = 0; hi = arr.length - 1
    }

    static void quickSort(int[] arr, int low, int hi) {
        if(low >= hi) {
            return;
        }

        int s = low;
        int e = hi;
        int m = s + (e - s ) / 2;

        int pivot = arr[m];

        while(s <= e) {

            if(arr[s] < pivot) {
                s++;
            }

            if(rr[e] > pivot) {
                e--;
            }

            if(s <= e) {
                // swap
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
                s++;
                e--;
            }
        }

        // now my pivot is at correct index, sort the two halves now 
        sort(arr, low, e);
        sort(arr, s, hi);
    }   
}