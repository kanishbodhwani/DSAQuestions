// selection sort
// take a element and put it at its correct index

// complexity O(n2)

public class SelectionSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] arr = {2,56,65,34,54,20};
        selectionSort(arr);
    }

    static void selectionSort(int[] arr) {
        for(int i = 0; i < arr.length; i++){
            // find the max item and place it at the correct index
            int lastIndex = arr.length - i - 1;
            int maxIndex = getMaxIndex(arr, 0, lastIndex);
            
            swap(arr, maxIndex, lastIndex);
        }
    }

    static int getMaxIndex(int[] arr, int start, int end){
        int max = start;
        for(int i = start; i <= end; i++) {
            if(arr[max] > arr[i]) {
                max = i;
            }
        }
        return ans;
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
