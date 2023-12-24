public class LinearSearch {
    public static void main(String[] args) {
        
        search([1,4,6,7,10], 10, 0);
        searchWithMultipleOccurence([1,4,6,7,7,10], 10, 0);
    }

    static void search(int[] arr, int target, int i) {
        if(arr.length == i) {
            return -1;
        }

        if(arr[i] == target) {
            return i;
        }
        return search(arr, target, i+1);
    }

    static ArrayList<Integer> list = new ArrayList<>();
    static int searchWithMultipleOccurence(int[] arr, int target, int i) {
        if(arr.length == i) {
            return -1;
        }

        if(arr[i] == target) {
            list.add(i);
        }
        return searchWithMultipleOccurence(arr, target, i+1);
    }

    // returning Arraylist
    // same as above
    static ArrayList<Integer> returnArrayListSearch(int[] arr, int target, int i, ArrayList<Integer> list) {
        if(arr.length == i) {
            return list;
        }
        if(arr[i] == target) {
            list.add(i);
        }
        return returnArrayListSearch(arr, target, i+1, list);
    }


    // Return the list without passing in the argument
    static ArrayList<Integer> returnListWithoutArgument(int[] arr, int target, int i) {
        ArrayList<Integer> list = new ArrayList<>();
        if(arr.length == i) {
            return list;
        }
        if(arr[i] == target) {
            list.add(i);
        }
        ArrayList<Integer> ansFromBelowCalls = returnListWithoutArgument(arr, target, i+1);
        list.addAll(ansFromBelowCalls);
        return list;
    }

}