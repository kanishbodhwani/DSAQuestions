// Calculate number of lines for outside loop 
// Bring out relationship between both rows and col 
// print 

public class Pattern {
    public static void main(String[] args) {
        pattern5(5);
    }

    static boolean pattern1(int n) {
        // *
        // * * 
        // * * * 
        // * * * *
        // * * * * *
        
        for(int row = 1; row <= n; row++) {
            for(int col = 1; col <= row; col++) {
                System.out.print("* ");
            }
           System.out.print("\n"); 
        }
    }

    static boolean pattern2(int n) {
        // * * * * * 
        // * * * * * 
        // * * * * *
        // * * * * *
        // * * * * *
        
        for(int row = 1; row <= n; row++) {
            for(int col = 1; col <= n; col++) {
                System.out.print("* ");
            }
           System.out.print("\n"); 
        }
    }

    static boolean pattern3(int n) {
        // * * * * * 
        // * * * * 
        // * * * 
        // * * 
        // * 
        
        for(int row = 1; row <= n; row++) {
            for(int col = 1; col <= n - row + 1; col--) {
                System.out.print("* ");
            }
           System.out.print("\n"); 
        }
    }

    static boolean pattern4(int n) {
        // 1
        // 1 2 
        // 1 2 3 
        // 1 2 3 4
        // 1 2 3 4 5
        
        for(int row = 1; row <= n; row++) {
            for(int col = 1; col <= row; col--) {
                System.out.print(col + " ");
            }
           System.out.print("\n"); 
        }
    }

    static void pattern5(int n) {
        // *
        // * * 
        // * * * 
        // * * * *
        // * * * * *
        // * * * *
        // * * * 
        // * * 
        // *
        
        for(int row = 0; row < 2*n; row++) {
            int totalCols = row > n ? 2*n - row: row;
            for(int col = 0; col < totalCols; col--) {
                System.out.print("* ");
            }
            System.out.print("\n");
        }
    }

    static void pattern6(int n) {
        //     *
        //    * * 
        //   * * * 
        //  * * * *
        // * * * * *
        //  * * * *
        //   * * * 
        //    * * 
        //     *
        
        for(int row = 0; row < 2*n; row++) {
            int totalCols = row > n ? 2*n - row: row;
            
            int gaps = n - totalCols;
            for(int i = 0; i < gaps; i++) {
                System.out.print(" ");
            }

            for(int col = 0; col < totalCols; col--) {
                System.out.print("* ");
            }
            System.out.print("\n");
        }
    }

    static void pattern7(int n) {
//             1
//           2 1 2 
//         3 2 1 2 3 
//       4 3 2 1 2 3 4
//     5 4 3 2 1 2 3 4 5
        
        for(int row = 1; row <= n; row++) {
            int gaps = n - row;
            for(int i = 0; i < gaps; i++) {
                System.out.print("  ");
            }
            for(int col = row; col >= 1; col--) {
                System.out.print(col + " ");
            }
            for(int col = 2; col <= row; col++) {
                System.out.print(col + " ");
            }
            System.out.print("\n");
        }
    }

    
}