public static void main(String[] args) {
    public static void sequence(int[] arr, int index, ArrayList<Integer> list) {
        if(index >= arr.length) {
            System.out.println(list);
            return;
        }
        list.add(arr[index]);
        sequence(arr, index+1, list);
        list.remove(arr[index]);
        sequence(arr, index + 1, list);
    } 
};

