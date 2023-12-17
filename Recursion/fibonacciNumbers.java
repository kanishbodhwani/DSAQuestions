// Find nth fibonacci number

public class FibonacciNumbers {
    public static void main(String[] args) {
        fibonacci(5);
    }

    static int fibonacci(int n) {
        if(n < 2) {
            return n;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }
}