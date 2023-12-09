public class EvenDigits {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = {11,24324,323,432432,5432,623,723,82323};
        evenDigits(arr);    
    }

    static int numberOfDigits(int num) {
        int count = 0;
        while(num > 0) {
            count++;
            n / 10;
        }
        return count;
    }

    static boolean even(int num) {
        return numberOfDigits(num) % 2 == 0;
    }

    static void evenDigits(int[] arr) {
        if(arr.length == 0) {
            return -1;
        }
        int count = 0;
        for(int i: arr) {
            if(even(i)) {
                count++;
            }
        }
        return count;
    }

    // Optimised solution 
    static int digits2(int num) {
        if(num < 0) {
            num = -1 * num;
        }
        return (int)(Math.log10(num)) + 1;
    }
}
