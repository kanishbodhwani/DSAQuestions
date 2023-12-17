// Binary Search with recurion

public class BinarySearch {
    public static void main(String[] args) {
        // Input
    }

    static int search(int[] arr, int target, int s, int e) {
        if(s > e) {
            return - 1;
        }

        int m = s + (e - s) / 2;

        if(arr[m] == target) {
            return m;
        }

        if(target > arr[m]) {
            return search(arr, target, m+1, e);
        }
        return search(arr, target, s, m-1);
    }
}   