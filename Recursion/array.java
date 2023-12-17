// Find array is sorted or not

public class Array {
    public static void main(String[] args) {
        arraySorted([1,4,6,7,10]);
    }

    static boolean arraySorted(int[] arr, int i) {
        if(arr.length-1 == i) {
            return true;
        }

        if(arr[i] < arr[i+1]) {
            return arraySorted(arr, i+1);
        } else return false;
    }
}