public static void sumnumbers(int n, int sum) {
    if(n == 0) {
        System.out.println(sum);
        return;
    }
    sum += n;
    sumnumbers(n- 1, sum);
}

public static void sumnumbers2(int n) {
    if(n == 0) {
        return 0;
    }
    return n + sumnumbers(n- 1);
}