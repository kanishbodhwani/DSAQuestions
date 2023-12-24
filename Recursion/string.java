public class Subset {
    public static void main(String[] args) {

    }
    // Ques 1
    // Skip a and return the remaining string 
    // my answer
    static String skip(String str, int i, String result) {
        if(i == str.length()) {
            return;
        }
        
        if(str.charAt(i) != 'a') {
            result = result + str.charAt(i);
        }

        skip(str, i+1, result);
        return result;
    }

    // Same question 
    // kunal answer 1
    static void skip1(String p, String up) {
        if(up.isEmpty()) {
            System.out.println(p);
            return;
        }

        char ch = up.chatAt(0);

        if(ch == 'a') {
            skip(p, up.substring(1));
        } else {
            skip(p + ch, up.substring(1));
        }
    }

    // Same question 
    // kunal answer 2
    static String skip2(String up) {
        if(up.isEmpty()) {
            return "";
        }

        char ch = up.chatAt(0);

        if(ch == 'a') {
            return skip(up.substring(1));
        } else {
            return ch + skip(up.substring(1));
        }
    }

    // Ques 2
    // Skip a string -> eg 'apple'
    static String skipString(String up) {
        if(up.isEmpty()) {
            return "";
        }

        if(up.startsWith('apple')) {
            return skipString(up.substring(5));
        } else {
            return up.charAt(0) + skipString(up.substring(1));
        }
    }


    // Ques 3 
    // Only skip the string if its not equal to some string 
    // eg only skip 'app' when its != 'apple'
    static String skipAppNotApple(String up) {
        if(up.isEmpty()) {
            return "";
        }

        if(up.startsWith('app') && !up.startsWith('apple')) {
            return skipAppNotApple(up.substring(3));
        } else {
            return up.charAt(0) + skipAppNotApple(up.substring(1));
        }
    }

}