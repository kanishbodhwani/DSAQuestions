public class DynamicArrays {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // ArrayList
        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(34);
        list.add(56);
        list.contains(56);
        list.set(0, 99); // set the 0th index to 99
        list.remove(2);  // remove index 2 
        list.get(i) // get the ith element 
    }

    static void reverse(int [] arr) {
        int start = arr[0];
        int end = arr[length - 1];

        while(start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }

        return arr;
    }
}
