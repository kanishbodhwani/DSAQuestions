public class MaxWealth {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] arr = {{1,2,3}, {2,3}, {5,6}};
        maxWealth(arr);    
    }

    static int maxWealth(int[][] accounts) {
        int ans = Interger.MIN_VALUE;
        for(int[] ints: accounts) {
            int sum = 0;
            for(int j: ints) {
                sum += j;
            }

            if(sum > ans) {
                ans = sum;
            } 
        }
        return ans;
    }
}
