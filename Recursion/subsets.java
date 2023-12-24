public class Subsets {
    public static void main(String[] args) {

    }

    // Ques 1 
    // find all subsets of a srting 
    // eg 'abc'
    static void subset(String p, String up) {
        if(up.isEmpty()) {
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);

        subset(p + ch, up.substring(1));
        subset(p, up.substring(1));
    }

    // Same question
    // Arraylist of a string
    // Same as explained in array's recursion 

    static ArrayList<String> subset2(String p, String up) {
        if(up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);

        ArrayList<String> left = subset2(p + ch, up.substring(1));
        ArrayList<String> right = subset2(p, up.substring(1));

        left.addAll(right);
        return left;
    }

    // Ques 2
    // Print ASCII value of a character also with the above string 

    static ArrayList<String> subsetAscii(String p, String up) {
        if(up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);

        ArrayList<String> left = subsetAscii(p + ch, up.substring(1));
        ArrayList<String> right = subsetAscii(p, up.substring(1));
        ArrayList<String> ascii = subsetAscii(p + (ch+0), up.substring(1));

        left.addAll(right);
        left.addAll(ascii);
        return left;
    }

    // Ques 3 [1,2,3]
    // print all subsets of array 
    // Time complexity O(N * 2 powerN)
    // Space complexity O(N * 2 powerN) 
    static List<List<Interger>> subsetArray(int[] arr) {
        List<List<Interger>> outer = new ArrayList<>();

        outer.add(new ArrayList<>());

        for(int num: arr) {
            int n = outer.size();
            for(int i = 0; i < n; i++) {
                List<Integer> internal = new ArrayList<>(outer.get(i)); // making a copy of outer elements till now
                internal.add(num);
                outer.add(internal);
            }
        }

        return outer;
    } 

    // Ques 4 [1,2,2,3] with duplicates
    // print all subsets of array 
    // Time complexity O(N * 2 powerN)
    // Space complexity O(N * 2 powerN) 
    static List<List<Interger>> subsetArrayWithDuplicates(int[] arr) {
        Arrays.sort(arr);
        List<List<Interger>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        int start = 0;
        int end = 0;
        for(int i = 0; i < arr.length; i++) {
            start = 0;
            // if current and prev el is same, s = e + 1;
            if(i > 0 && arr[i] == arr[i-1]) {
                start = end + 1;
            }
            end = outer.size() - 1;
            int n = outer.size();
            for(int j = start; j < n; j++) {
                List<Integer> internal = new ArrayList<>(outer.get(j)); // making a copy of outer elements till now
                internal.add(arr[i]);
                outer.add(internal);
            }
        }
        return outer;
    }

}