public class Methods {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = {1,2,3,4,5};
        System.out.println(Arrays.toString(arr));
        // will print {1,2,3,4,5}

        String str[] = new String(4);
        for(String s in str) {
            s = in.next();
        }   
        System.out.println(Arrays.toString(str));
    }
}
