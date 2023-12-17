
public class SumOfDigits {
    public static void main(String[] args) {
        sod(5);
    }

    static int sod(int n) {
        if(n == 0) {
            return 0;
        }

        int digit = n % 10;
        return digit + sod(n/10);
    }

    static int pod(int n) {
        if(n%10 == n) {
            return n;
        }
        return (n%10) * pod(n/10);
    }

    static int sum = 0;
    static void reverse(int n) {
        if(n == 0) {
            return;
        }
        int rem = rem % 10;
        sum = sum * 10 + rem;
        reverse(n/10);
    }

    static boolean palindrome(int n) {
        return n == reverse(n);
    }
}