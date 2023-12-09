package DSAwithMe;

public class infiniteArray {
    public static void main(String[], args) {
        int[] arr = {3,4,8,10,34,56,70,73,77,80,85,90,100};
        int target = 10;
        System.out.println(findingRange(arr, target))
    }
    
    static int findingRange(int[] arr, int target) {
        // start with the box of size 2
        int start = 0;
        int end = 1;
        
        while(target > arr[end]) {
            int newStart = end + 1;
            // double the box value
            // new end is end + sizeofbox*2
            end = end + (end - start + 1) * 2;
            start = newStart;
        }
        return binarySearch(arr, target, start, end);
    }
    
    int binarySearch(int[] arr, int target, int start, int end) {
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(target < arr[mid]) {
                end = mid - 1; 
            } else if(target > arr[mid]){
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1; 
    }

}