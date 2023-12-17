// Find nth fibonacci number

public class Nto1 {
    public static void main(String[] args) {
        printNto1(5); // 5 4 3 2 1
        print1toN(5); // 1 2 3 4 5 
    }

    static void printNto1(int n) {
        if(n == 0) {
            return;
        }
        System.out.println(n);
        print(n - 1);
    }


    static void print1toN(int n) {
        if(n == 0) {
            return;
        }
        print(n - 1);
        System.out.println(n);
    }

    static int fact(int n) {
        if(n <= 1) {
            return 1;
        }

        return n * fact(n - 1);
    }


    static int sum(int n) {
        if(n <= 1) {
            return 1;
        }

        return n + sum(n - 1);
    }
}