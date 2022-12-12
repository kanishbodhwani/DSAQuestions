public static void printnums2(int n) {
        if(n == 0) {
            return;
        }
        n--;
        printnums2(n);
        System.out.println(n + 1);
    }

public static void printnums(int n) {
        // n to 1
        if(n == 0) {
            return;
        }

        System.out.println(n);
        n--;
        printnums(n);
    }