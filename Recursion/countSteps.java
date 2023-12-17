public class CountSteps {
    public static void main(String[] args) {
        count(500);
    }

    static void count(int n, int steps) {
        if(n == 0) {
            return steps;
        }
        if(n % 2 == 0) {
            return count(n/2, steps+1);
        }   
        return count(n-1, steps+1);
    }
}