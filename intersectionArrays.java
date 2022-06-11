import java.util.ArrayList;
import java.util.Arrays;

public class Intersection {
    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};

        int[] array = intersection(nums1, nums2);
        System.out.println(Arrays.toString(array));
    }
    static int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> arr = new ArrayList<Integer>();

        for(int i = 0; i < nums1.length; i++) {
            for(int j = 0; j < nums2.length; j++) {
                if(nums1[i] == nums2[j] && !arr.contains(nums1[i])) {
                    arr.add(nums1[i]);
                }
            }
        }

        System.out.println(arr);
        int[] array = new int[arr.size()];
        for(int i = 0; i < arr.size(); i++) {
            array[i] = arr.get(i);
        }
        return array;
    }
}
