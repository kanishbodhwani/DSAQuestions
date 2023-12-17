public class CountZeros {
    public static void main(String[] args) {
        count(500);
    }

    static void count(int n, int count) {
        if(n == 0) {
            return count;
        }

        int digit = n % 10;        
        if(digit == 0) {
            return count(n/10, count+1);
        } 
        return count(n/10, count);
    }
}