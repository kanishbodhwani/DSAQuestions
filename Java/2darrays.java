public class 2DArrays {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[][] arr2 = new int[3][3];

        int[][] arr = {
            {1,2,3,4,5},
            {6,7,8,9,10}
        };

        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                System.out.println(arr[i][j]);  
            }
        }

    }
}
