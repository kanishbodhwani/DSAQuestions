// find the smallest letter greater than the target

// https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/

// if cant find then return 0th el

// smallest number greater than or == target

public class SmallestLetter {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        char[] arr = ["c","f","j"];
        char target = "a";
    }

    static void smallestLetter(char[] arr, char target) {
        if(arr.length == 0) {
            return -1;
        }

        int start = 0;
        int end = arr.length - 1;

        while(start <= end) {
            int mid = start + (end - start) / 2;

            if(target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            }
        }

        return arr[start % arr.length];

    }
}
