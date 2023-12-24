public class Permutations {
    public static void main(String[] args) {

    }

    // Ques 1 
    // return all the permutation combination of string abc
    static void permutation(String p, String up) {
        if(up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        for(int i = 0; i <= p.length(); i++) {
            String f = p.substring(0,i);
            String s = p.substring(i, p.length());
            permutation(f + ch + s, up.substring(1));
        }
    }

    // Same but returning with list
    static ArrayList<String> permutationList(String p, String up) {
        if(up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);

        ArrayList<String> ans = new ArrayList<>();

        for(int i = 0; i <= p.length(); i++) {
            String f = p.substring(0,i);
            String s = p.substring(i, p.length());
            ans.addAll(permutationList(f + ch + s, up.substring(1)));
        }

        return ans;
    }

    // Count number of permutations 
    static int permutationsCount(String p, String up) {
        if(up.isEmpty()) {
            return 1;
        }
        int count = 0;
        char ch = up.charAt(0);
        for(int i = 0; i <= p.length(); i++) {
            String f = p.substring(0,i);
            String s = p.substring(i, p.length());
            count = count + permutationsCount(f + ch + s, up.substring(1));
        }
        return count;
    }

    // Google question 
    // Letter combinations of a Phone number - keypad phone

    static void pad(String p, String up) {
        if(up.isEmpty()) {
            System.out.println(p);
            return;
        }
        int digit = up.charAt(0) - '0'; // this will convert '2' into 2;
        for(int i = (digit-1) * 3; i < digit * 3; i++) {
            char ch = (char)('a' + i);
            pad(p + ch, up.substring(1));
        }
    }

    // Returning ArraList
    static ArrayList<String> padArr(String p, String up) {
        if(up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        int digit = up.charAt(0) - '0'; // this will convert '2' into 2;
        ArrayList<String> list = new ArraList<>();
        for(int i = (digit-1) * 3; i < digit * 3; i++) {
            char ch = (char)('a' + i);
            list.addAll(padArr(p + ch, up.substring(1)));
        }
        return list;
    }

    // Returning count
    static int padCount(String p, String up) {
        if(up.isEmpty()) {
            return 1;
        }
        int count = 0;
        int digit = up.charAt(0) - '0'; // this will convert '2' into 2;
        for(int i = (digit-1) * 3; i < digit * 3; i++) {
            char ch = (char)('a' + i);
            count = count + padCount(p + ch, up.substring(1));
        }

        return count;
    }


    // Dice question // Amazon Question
    // how many ways are there to form 4 on a dice

    static void dice(String p, int target) {
        if(target == 0) {
            System.out.println(p);
            return;
        }

        for(int i = 1; i <= 6 && i <= target; i++) {
            dice(p + i, target - 1);
        }
    }
}