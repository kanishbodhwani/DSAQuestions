// Space complexity rowLength + colLength; 

//class Solution {
//    public void setZeroes(int[][] matrix) {
//        setMatrixZeros(matrix);
//    }
//    
//    
//    int[][] setMatrixZeros(int[][] arr) {
//        int rowLenght = arr.length;
//        int colLength = arr[0].length;
//        
//        boolean[] row_arr = new boolean[rowLength];
//        boolean[] col_arr = new boolean[colLength];
//        
//        for(int row = 0; row < rowLength; row++) {
//            for(int col = 0; col < colLength; col++) {
//                if(arr[row][col] == 0) {
//                    row_arr[row] = true;
//                    col_arr[col] = true;
//                }
//            }
//        }
//        
//        for(int row = 0; row < rowLength; row++) {
//            for(int col = 0; col < colLength; col++) {
//                if(row_arr[row] || col_arr[col]) {
//                    arr[row][col] = 0;
//                } 
//            }
//        }
//        
//    }
//}


// for constant space complexity 


class Solution {
    public void setZeroes(int[][] matrix) {
        setMatrixZeros(matrix);
    }
    
    
    int[][] setMatrixZeros(int[][] arr) {
        if(arr == null) {
            return;
        }
        
        int m = arr.length;
        int n = arr[0].length;
        
        bool x = false;
        bool y = false;
        
        for(int i = 0; i < m; i++) {
            if(arr[i][0] == 0) {
                y = true;
            }
        }
        
        for(int j = 0; j < n; j++) {
            if(arr[0][j] == 0) {
                x = true;
            }
        }
        
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(arr[i][j] == 0) {
                    arr[i][0] = 0;
                    arr[0][j] = 0;
                }
            }
        }
        
        for(int i = 1; i < m; i++) {
            if(arr[i][0] == 0) {
                for(int j = 1; j < n; j++) {
                    arr[i][j] = 0;
                }
            }
        }
        
        for(int j = 1; j < n; j++) {
            if(arr[0][j] == 0) [
                for(int i = 1; i < n; i++) {
                    arr[i][j] = 0;
                }
            ]
        }
        
        if(y == true) {
            for(int i = 0; i< m; i++) {
                arr[i][0] = 0;
            }
        }
        
        if(x == true) {
            for(int j = 0; j < n; j++) {
                arr[0][j] = 0;
            }
        }
        
    }
}





///   1 2 3 0 
      3 0 5 6 
      0 6 0 9
