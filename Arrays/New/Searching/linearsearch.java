public class LinerSearch {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // ArrayList
        list.add(34);
        list.add(56);
        list.contains(56);
        list.set(0, 99); // set the 0th index to 99
        list.remove(2);  // remove index 2 
        list.get(i) // get the ith element 
    }

    static void linearSearch(int [] arr) {
        if(arr.length == 0) {
            return -1;
        }

        for(int index = 0; index < arr.length; index++) {
            int element = arr[index];
            if(element == target) {
                return index;
            }
        }

        return -1;
    }
}
