public static void main(int[] arr) {
    ArrayList<Integer> list = new ArrayList<>();
    public void subArray(int[] arr, int index = 0) {
        ArrayList<Integer> subList = new ArrayList<>();
        if(arr.length >= index) {
            System.out.println(Arrays.toString(list));
        }
        subList.add(arr[index]);
        subList.add(arr[index + 1]);
        subArray(arr, index + 1);
    } 
}

[1,2,3]
[0,1,2]

