// Binary Search 
// ceiling  - smallest, greater than target
// floor - greatest, smaller than target
// Even digits
// first and last position 
// Infinite sorted array
// Max Wealth 

static int binarySearch(int[] arr, int target) {
    if(arr.length == 0) {
        return -1;
    }
    int start = 0;
    int end = arr.length - 1;

    while(start <= end) {
        int mid = start + (end - start) / 2;

        if(target > arr[mid]) {
            start = mid + 1;
        } else if (traget < arr[mid]) {
            end = mid - 1;
        } else {
            return mid;
        }
    }
    return -1;
}


static int ceiling(int[] arr, int target) {
    if(arr.length == 0) {
        return -1;
    }

    int start = 0;
    int end= arr.length - 1;

    while(start <= end) {
        int mid = start + (end - start) / 2;

        if(target < arr[mid]) {
            end = mid - 1;
        } else if(target > arr[mid]) {
            start = mid + 1;
        } else {
            return mid;
        }
    }

    return start; // because it will be the greater than end and will be the smallest, greater than target
}

static int floor(int[] arr, int target) {
    if(arr.length == 0) {
        return -1;
    }

    int start = 0;
    int end= arr.length - 1;

    while(start <= end) {
        int mid = start + (end - start) / 2;

        if(target < arr[mid]) {
            end = mid - 1;
        } else if(target > arr[mid]) {
            start = mid + 1;
        } else {
            return mid;
        }
    }

    return end; // because it will be the smllar than start and will be the greatest, smaller than target
}

int arr = {11, 345, 5785, 7289, 679, 182908};
static int evenDigits(int[] arr) {
    int count = 0;
    for(int i: arr) {
        if(isEven(i)) {
            count++;
        }
    }
    return count;    
}
static boolean isEven(int num) {
    return numberOfDigits(num) % 2 == 0;
}
static int numberOfDigits(int num) {
    int count = 0;
    while(num > 0) {
        num = num / 10;
        count++;
    }
    return count;
}

static int[] firstAndLast(int[] arr, int target) {
    int[] ans = {-1, -1};

    if(arr.length == 0) {
        return ans;
    }

    int first = helper(arr, target, true);
    int last = helper(arr, target, false);    
    
    return {first, last};
}
static int helper(int[] arr, int target, isFirst) {
    int ans = -1;
    int start = 0;
    int end = arr.length - 1;

    while(start < end) {
        int mid = start + (end - start) / 2;

        if(target > arr[mid]) {
            start = mid + 1;
        } else if (target < arr[mid]) {
            end = mid - 1;
        } else {
            ans = mid;
            // potential ans
            if(isFirst) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }
}

// can't take ans.length 
int ans = {1,5,12,23,65,89,90 ....};
static int infiniteSortedArray(int[] arr, int target) {
    int start = 0;
    int end = 1;

    while(target > arr[end]) {
        int temp = end;
        end = end + (end - start + 1) * 2;
        start = temp;
    }

    return searchInRange(arr, target, start, end);
}
static int searchInRange(int[] arr, int target, int start, int end) {
    while(start <= end) {
        int mid = start + (end - start) / 2;

        if(target > arr[mid]) {
            start = mid + 1;
        } else if (target < arr[mid]) {
            end = mid - 1;
        } else {
            return mid;
        }
    }

    return -1;
}

int arr = {{1,2,4}, {9,8}, {0,6,7}};
static int maxWealth(int[][] arr) {
    int ans = Math.MIN_VALUE;

    if(arr.length == 0) {
        return ans;
    }

    for(int i: arr) {
        int max = sumOfNums(i);
        if(max > ans) {
            ans = max;
        }
    }1

    return ans;
}
static int sumOfNums(int[] arr) {
    int sum = 0;
    for(int i: arr) {
        sum += i;
    }
    return sum;
}

// Search in Rotated sorted array
// Pivot with duplicates
// Rotation count
// Mountain peak
// Search in Mountain Array
// Smallest letter
// Split array largest sum

int[] arr = {23,67,2,4,8}
static int rotatedSortedArray(int[] arr, int target) {
    int pivot = findPivot(arr);

    if(pivot == -1) {
        return binarySearch(arr, target, 0, arr.length - 1);
    }

    if(pivot == target) {
        return pivot;
    }

    if(target < pivot) {
        return binarySearch(arr, target, 0, pivot);
    }

    return binarySearch(arr, target, pivot + 1, arr.length - 1);
}
static int findPivot(int[] arr) {
    int start = 0;
    int end = arr.length - 1;

    while(start <= end) {
        int mid = start + (end - start) / 2;

        if(mid < end && arr[mid] > arr[mid + 1]) {
            return mid;
        } else if(mid > start && arr[mid] < arr[mid - 1]) {
            return mid - 1;
        } else if(arr[start] >= arr[mid]) {
            end = mid - 1;
        } else {
            start = mid + 1;
        }
    }

    return -1;
}
static int binarySearch(int[] arr, int target, int start, int end) {
    while(start < end) {
        int mid = start + (end - start) / 2;

        if(target > arr[mid]) {
            start = mid + 1;
        } else if(target < arr[mid]) {
            end = mid - 1;
        } else {
            return mid;
        }
    }

    return -1;
}

// {2,2,5,2}
static int pivotWithDuplicates(int[] arr) {
    int start = 0;
    int end = arr.length - 1;

    while(start <= end) {
        int mid = start + (end - start) / 2;

        if(mid < end && arr[mid] > arr[mid + 1]) {
            return mid;
        }
        
        if(mid > start && arr[mid] < arr[mid - 1]) {
            return mid - 1;
        }

        if(arr[mid] == arr[start] && arr[mid] == arr[end]) {
            // check if start is pivot
            if(arr[start] > arr[start + 1]) {
                return start;
            }
            start++;

            // check if end is pivot
            if(arr[end] < arr[end - 1]) {
                return end - 1;
            }
            end--;
        } else if(arr[start] < arr[mid] || (arr[mid] == arr[start] && arr[mid] > arr[end])) {
            start = mid + 1;
        } else {
            end = mid - 1;
        }
    }

    return -1;
}

static int rotationCount(int[] arr) {
    int pivot = findPivot(arr);
    if(pivot == -1) {
        return 0;
    }
    return pivot + 1;
}
static int findPivot(int[] arr) {
    int start = 0;
    int end = arr.length - 1;

    while(start <= end) {
        int mid = start + (end - start) / 2;

        if(mid < end && arr[mid] > arr[mid + 1]) {
            return mid;
        } else if(mid > start && arr[mid] < arr[mid - 1]) {
            return mid - 1;
        } else if(arr[start] >= arr[mid]) {
            end = mid - 1;
        } else {
            start = mid + 1;
        }
    }

    return -1;
}

static int mountainPeek(int[] arr) {
    if(arr.length == 0) {
        return -1;
    }

    int start = 0;
    int end = arr.length - 1;

    while(start < end) {
        int mid = start + (end - start) / 2;

        if(arr[mid] < arr[mid + 1]) {
            // asc
            start = mid + 1;
        } else {
            // desc
            end = mid;
        }
    }

    return - 1;
}

static int searchInMountain(int[] arr, int target) {
    if(arr.length == 0) {
        return -1;
    }
    
    int peak = mountainPeek(arr);

    if(target > peak) {
        return binarySearch(arr, target, peak + 1, arr.length - 1);
    }
    return binarySearch(arr, target, 0, peak);
}

// char[] arr = ["c","f","j"];
// char target = "a";
static int smallestLetterGreaterThanTarget(char[] arr, char target) {
    int start = 0;
    int end = arr.length - 1;

    while(start < end) {
        int mid = start + (end - start) / 2;

        if(target > arr[mid]) {
            start = mid + 1;
        } else {
            end = mid - 1;
        }
    }

    return arr[start % arr.length];
}

// int[] arr = {9,23,1,3,5,7};
static int splitArray(int[] nums, int m) {
    int start = 0;
    int end = 0;

    for(int i = 0; i < arr.length; i++) {
        start = Math.max(start, arr[i]);
        end += arr[i];
    }

    while(start < end) {
        int mid = start + (end - start) / 2;
        int sum = 0;
        int count = 0;

        for(int num: nums) {
            if(sum + num > mid) {
                sum = num;
                count++;
            } else {
                sum += num;
            }
        }

        if(count > m) {
            start = mid + 1;
        } else {
            end = mid;
        }
    }

    return start;
}


// SORTING.....

// O(n2)
// Bubble sort
// Insertion sort
// Selection sort


static void bubbleSort(int[] arr) {
    boolean swapped;

    for(int i = 0; i < arr.length; i++) {
        swapped = false;
        for(int j = 1; j < arr.length - i; j++) {
            if(arr[j] < arr[j-1]) {
                // swap 
                swap(arr, j, j-1);
                swapped = true;
            }
        }

        if(!swapped) {
            break;
        }
    }
}

// solve lhs
static void insertionSort(int[] arr) {
    for(int i = 0; i < arr.length; i++) {
        for(int j = i + 1; j > 0; j--) {
            if(arr[j] < arr[j-1]) {
                swap(arr, j, j-1);
            } else {
                break;
            }
        }
    }
}

// Take largest and put it at the end
static void selectionSort(int[] arr) {   
    for(int i = 0; i < arr.length; i++) {

        int lastIndex = arr.length - i - 1;
        int maxIndex = getMaxIndex(arr, 0, lastIndex);

        swap(arr, maxIndex, lastIndex);
    }
}

static int getMaxIndex(int[] arr, int start, int end) {
    int max = start;
    for(int i = start; i <= end; i++) {
        if(arr[i] > arr[max]) {
            max = i;
        }
    }
    return max;
}

// swap
static void swap(int[] arr, int a, int b) {
    int temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
}

// O(n)
// Cycle sort
// Missing number
// Dissapear 
// Duplicate
// All Duplicates
// Set Mismatch
// First missing positive

// [0,n]
static void cycleSort(int[] arr) {
    int i = 0;
    while(i < arr.length) {
        int correct = arr[i] - i;
        if(arr[correct] != arr[i]) {
           swap(arr, correct, i);
        } else {
            i++;
        }
    }
}
static void swap(int[] arr, int a, int b) {
    int temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
}

// [0,n]
static void missingNumber(int[] arr, int n) {
    int i = 0;

    while(i < arr.length) {
        int correct = arr[i] - i;
        if(arr[correct] != arr[i]) {
            swap(arr, correct, i);
        } else {
            i++;
        }
    }

    for(int num: arr) {
        if(arr[num] != num) {
            return num;
        }
    }

    return arr.length;
}

// [1,n]
static int[] dissapear(int[] arr, int n) {
    int i = 0;

    while(i < arr.length) {
        int correct = arr[i] - i;
        if(arr[i] != arr[correct]) {
            swap(arr, correct, i);
        } else {
            i++;
        }
    }

    List<Integer> list = new ArrayList<>();
    for(int num: arr) {
        if(arr[num] != num + 1) {
            list.add(num);
        }
    }

    return list;
}

static int duplicate(int[] arr) {
    int i = 0;

    while(i < arr.length) {
        if(arr[i] != i + 1) {
            int correct = arr[i] - i;
            if(arr[i] != arr[correct]) {
                swap(arr, correct, i);
            } else {
                return arr[i];
            }
        } else {
            i++;
        }
    }

    return -1;
}

// [4,3,2,7,8,2,3,1]
static int[] allDuplicates(int[] arr) {
    int i = 0;

    while(i < arr.length) {
        int correct = arr[i] - i;
        if(arr[i] < arr.length && arr[i] != arr[correct]) {
            swap(arr,correct,i);
        } else {
            i++;
        }
    }

    List<Integer> list = new ArrayList<>();
    for(int num: arr) {
        if(arr[num] != num + 1) {
            list.add(num + 1);
        }
    }

    return new int[]{-1,-1};
}

// [1,2,2,4];
// [2,3]
static int[] setMismatch(int[] arr) {
    int i = 0;
    while(i < arr.length) {
        int correct = arr[i] - i;
        if(arr[correct] != arr[i]) {
            swap(arr,i,correct);
        } else {
            i++;
        }
    }


    for(int num: arr) {
        if(arr[i] != i+1) {
            return new int[] {arr[i], i+1};
        }
    }

    return new int[]{-1,-1};
}

// [1,2,0];
// 3
static int firstMissingPositive(int[] arr) {
    int = 0;
    while(i < arr.length) {
        int correct = arr[i] - i;
        if(arr[i] > 0 && arr[i] <= arr.length && arr[i] != arr[correct]) {
            swap(arr, i , correct);
        } else {
            i++;
        }
    }

    for(int num: arr) {
        if(arr[num] != num + 1) {
            return num + 1;
        }
    }

    return arr.length + 1;
}