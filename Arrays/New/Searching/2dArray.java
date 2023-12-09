public class Matrix {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] arr = {{9,23,1,3,5,7}, {4,6,7}, {10, 78, 99}};
    }

    static int[] search(int[][] matrix, int target) {
        int r = 0;
        int c = matrix.length - 1;

        while(r < matrix.length && c >= 0) {
            if(matrix[r][c] == target) {
                return new int[]{r,c};
            }
            if(matrix[r][c] < target) {
                r++;
            } else {
                c--;
            }
        }
        return new int[]{-1,-1};
    }

    // in a sorted matrix
    // different question
    static int[] binarySearch(int[][] matrix, int row, int cStart, int cEnd, int target) {
        while(cStart <= cEnd) {
            int mid = cStart + (cEnd - cStart) / 2;

            if(matrix[row][mid] == target) {
                return new int[]{row, mid};
            } 

            if(matrix[row][mid] < target) {
                cStart = mid;
            } else {
                cEnd = mid;
            }
        }
        return new int[]{-1,-1};
    }

    static int[] searchSortedMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        if(rows == 1) {
            return binarySearch(matrix, 0, 0, cols - 1, target);
        }

        int rStart = 0;
        int rEnd = rows - 1;
        int cMid = cols / 2;

        while(rStart < (rEnd - 1)) { // while this is true it will have more than 2 rows 
            int mid = rStart + (rEnd - rStart) / 2;

            if(matrix[mid][cMid] == target) {
                return new int[]{mid,cMid};
            }

            if(matrix[mid][cMid] < target) {
                // remove above rows
                rStart = mid;
            } else {
                rEnd = mid;   
            }
        } 


        // now only 2 rows are remaining
        // check whether target is in col of 2 rows
        if(matrix[rStart][cMid] == target) {
            return new int[]{rStart,cMid};
        }

        if(matrix[rStart + 1][cMid] == target) {
            return new int[]{rStart + 1, cMid}
        }

        // 4 cases 
        if(target <= matrix[rStart][cMid - 1]) {
            return binarySearch(matrix, rStart, 0, cMid - 1, target);
        } else if(target <= matrix[rStart + 1][cMid - 1]) {
            return binarySearch(matrix, rStart + 1, 0, cMid - 1, target);
        } else if(target >= matrix[rStart][cMid + 1] && target <= matrix[rStart][cols - 1]) {
            return binarySearch(matrix, rStart, cMid + 1, cols - 1, target);
        } else {
           return binarySearch(matrix, rStart + 1, cMid + 1, cols - 1, target);
        }

    }

}