public class Recursion2 {
    static int a = 5;
    public static void main(String[] args) {
        recursion();
    }

    public static void recursion() {
        if (a == 0) {
            return;
        }
        System.out.println("Kanish");
        a--;
        recursion();
    }
}

