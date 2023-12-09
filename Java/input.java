public class input {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] arr = {1,2,3,4,5};

        for(int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }

        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        // enhanced for loop 
        for(int num: arr) {
           System.out.println(num);
        }
    }
}
