// bubble sort == Sinking sort == Exchange sort
// compare adjacent elements at every step

// Stable and Unstable sorting algorithms 
// means when the original order is maintained for values that are equal = stable sorting

// complexity O(n2)

public class BubbleSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] arr = {2,56,65,34,54,20};
        bubbleSort(arr);
    }

    static void bubbleSort(int[] arr) {
        boolean swapped;
        // run the steps i - 1 times
        for(int i = 0; i < arr.length; i++) {
            swapped = false;
            // for each step max item will come at the last repective index
            for(int j = 1, j < arr.length - i; j++) {
                // swap if the item is smaller than the prev item
                if(arr[j] < arr[j - 1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j-1] = temp;
                    swapped = true;
                }
            }

            if(!swapped) {
                break;
            }
        }
    }
}
