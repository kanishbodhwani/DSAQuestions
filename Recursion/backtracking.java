public class Backtracking {
    public static void main(String[] args) {

    }

    // Ques 1
    // A Maze is given (r*c array) in which from (0,0) calculate how many ways we can go to (3,3) or any end
    // Can only go down and right
    static int count(int r, int c) {
        if(r == 1 || c == 1) {
            return 1;
        }

        int left = count(r-1, c);
        int right = count(r, c-1);

        return left + right;
    }

    // Same Question
    // print the path -- eg DDRR , DRDR 
    static void countPath(String p, int r, int c) {
        if(r == 1 && c == 1) {
            System.out.println(p);
            return;
        }

        if(r > 1) {
            countPath(p + "D", r-1, c);
        } 

        if(c > 1) {
            countPath(p + "R", r, c-1);
        }
    }

    // Same Question
    // Returning ArrayList
    static ArrayList<String> printPath(String p, int r, int c) {
        if(r == 1 && c == 1) {
           ArrayList<String> list = new ArrayList<>();
           list.add(p);
           return list;
        }

        ArrayList<String> list = new ArrayList<>();

        if(r > 1) {
            list.addAll(printPath(p + "D", r-1, c));
        } 

        if(c > 1) {
            list.addAll(printPath(p + "R", r, c-1));
        }

        return list;
    }

    // Same Question but can also go diagonally 
    // Returning ArrayList
    static ArrayList<String> printPathDiagonal(String p, int r, int c) {
        if(r == 1 && c == 1) {
           ArrayList<String> list = new ArrayList<>();
           list.add(p);
           return list;
        }

        ArrayList<String> list = new ArrayList<>();

        if(r > 1) {
            list.addAll(printPathDiagonal(p + "H", r-1, c));
        } 

        if(c > 1) {
            list.addAll(printPathDiagonal(p + "V", r, c-1));
        }

        if(r > 1 && c > 1) {
            list.addAll(printPathDiagonal(p + "D", r-1, c-1));
        }

        return list;
    }


    // Ques 2 
    // Maze with obstacles
    static void pathRestrictions(String p, boolean[][] maze, int r, int c) {
        if(r == maze.length - 1 && c == maze[0].length - 1) {
           System.out.println(p);
           return;
        }

        if(maze[r][c] == false) {
            return;
        }

        if(r < maze.length - 1) {
            pathRestriction(p + "D", maze, r+1, c);
        }

        if(c < maze[0].length - 1) {
            pathRestriction(p + "R", maze, r, c+1);
        }
    }


    // Ques 3 
    // Can go in all directions


    // Backtracking
    // While going back on recursion calls undo the changes that you did 
    // so it will be like it never went that route and we can get all the required answers
    static void allPaths(String p, boolean[][] maze, int r, int c) {
        if(r == maze.length - 1 && c == maze[0].length - 1) {
           System.out.println(p);
           return;
        }

        if(maze[r][c] == false) {
            return;
        }

        // Make a change 
        // marking it false so that it won't come here twice in the same recursion call
        maze[r][c] = false;

        if(r < maze.length - 1) {
            allPaths(p + "D", maze, r+1, c);
        }

        if(c < maze[0].length - 1) {
            allPaths(p + "R", maze, r, c+1);
        }

        if(r > 0) {
            allPaths(p + "U", maze, r-1, c);
        }

        if(c > 0) {
            allPaths(p + "L", maze, r, c-1);
        }

        // Undo the change when function gets removed from the stack
        // So that it will be ready for another recursion call 
        maze[r][c] = true;
    }

    // Same Question
    // Print matrix path also  
    static void allPathsPrint(String p, boolean[][] maze, int r, int c, int[][] path, int step) {
        if(r == maze.length - 1 && c == maze[0].length - 1) {
            path[r][c] = step; // add this step also
            for(int[] arr: path) {
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            System.out.println();
            return;
        }

        if(maze[r][c] == false) {
            return;
        }

        // Make a change 
        // marking it false so that it won't come here twice in the same recursion call
        maze[r][c] = false;
        path[r][c] = step;

        if(r < maze.length - 1) {
            allPathsPrint(p + "D", maze, r+1, c, path, step+1);
        }

        if(c < maze[0].length - 1) {
            allPathsPrint(p + "R", maze, r, c+1, path, step+1);
        }

        if(r > 0) {
            allPathsPrint(p + "U", maze, r-1, c, path, step+1);
        }

        if(c > 0) {
            allPathsPrint(p + "L", maze, r, c-1, path, step+1);
        }

        // Undo the change when function gets removed from the stack
        // So that it will be ready for another recursion call 
        maze[r][c] = true;
        path[r][c] = 0;
    }

    // it will print 
    // [1, 0, 0]
    // [2, 0, 0]
    // [3, 4, 5]
    // DDRR
    // and more ....


    // Questions backtracking
    // Ques 1
    // N Queens 
    // Number of ways to place N queens in a n*n chess box
    // Time complexity - O(N!)

    static int queens(boolean[][] board, int row) {
        if(row == board.length) {
            display(board);
            return 1;
        }

        int count = 0;

        // start placing queens
        for(int col = 0; col < board.length; col++) {
            // place the queen if it is safe
            if(isSafe(board, row, col)) {
                board[row][col] = true;
                count += queens(board, row+1);
                board[row][col] = false;
            }
        }

        return count;
    }


    public static boolean isSafe(boolean[][] board, int row, int col) {
        // check vertical row
        for(int i = 0; i < row; i++) {
            if(board[i][col] == true) {
                return false;
            }
        }

        // diagonal left
        int maxLeft = Math.min(row,col);
        for(int i = 1; i <= maxLeft; i++) {
            if(board[row-i][col-i]) {
                return false;
            }
        }

        // diagonal right
        int maxRight = Math.min(row,board.length - col - 1);
        for(int i = 1; i <= maxRight; i++) {
            if(board[row-i][col+i]) {
                return false;
            }
        }

        return true;
    }


    private static void display(boolean[][] board) {
        for(boolean[] row: board) {
            for(boolean element: row) {
                if(element) {
                    System.out.print("Q ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }


    // Ques 2 
    // N Knight problem 
    // We can also do this by the above method but this method is different, So covered both questions with both methods
    static void knight(boolean[][] board, int row, int col, int knights) {
        if(knights == 0) {
            display2(board);
            System.out.println();
            return;
        }

        if(row == board.length - 1 && col == board.length) {
            return;
        }

        if(col == board.length) {
            knight(board, row+1, 0, knights);
            return;
        }

        if(isSafe2(board, row, col)) {
            board[row][col] = true;
            knight(board, row, col+1, knights-1);            
            board[row][col] = false;
        }

        knight(board, row, col+1, knights);
    }

    private static boolean isSafe2(boolean[][] board, int row, int col) {
        if(isValid(board, row-2, col-1)) {
            if(board[row-2][col-1]) {
                return false;
            }
        }

        if(isValid(board, row-2, col+1)) {
            if(board[row-2][col+1]) {
                return false;
            }
        }
        
        if(isValid(board, row-1, col-2)) {
            if(board[row-1][col-2]) {
                return false;
            }
        }
        
        if(isValid(board, row-1, col+2)) {
            if(board[row-1][col+2]) {
                return false;
            }
        }

        return true;
    }

    // Do not repeat yourself so put it in another function 
    static boolean isValid(boolean[][] board, int row, int col) {
        if(row >= 0 && row < board.length && col >= 0 && col < board.length) {
            return true;
        }
        return false;
    }

    private static void display2(boolean[][] board) {
        for(boolean[] row: board) {
            for(boolean element: row) {
                if(element) {
                    System.out.print("K ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }


    // Ques 3
    // Sudoku solver

    static boolean solve(board[][]) {
        int n = board.length;
        int row = -1;
        int col = -1;

        boolean emptyLeft = true;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 0) {
                    row = i;
                    col = j;
                    emptyLeft = false;
                    break;
                }
            }
            if(emptyLeft == false) {
                break;
            }
        }

        if(emptyLeft == true) { // no empty found
            return true;
            // sudoku is solved
        }

        // backtrack
        for(int number = 1; number <= 9; number++) {
            if(isSafeSolver(board, row, col, number)) {
                board[row][col] = number;
                if(solve(board)) {
                    // found the ans
                    display(board);
                    return true;
                } else {
                    // backtrack
                    board[row][col] = 0;
                }
            }
        }

        return false;
    }

    private static void display(board[][]) {
        for(int[] row: board) {
            for(int num: row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    static boolean isSafeSolver(int[][] board, int row, int col, int num) {
        // check the row
        for(int i = 0; i < board.length; i++) {
            // check if the number is in the row or not
            if(board[row][i] == num) {
                return false;
            }
        }

        // check the col
        for(int[] nums: board) {
            if(nums[col] == num) {
                return false;
            }
        }

        // check the box
        int sqrt = (int)(Math.sqrt(board.length));
        int rowStart = row - row % sqrt;
        int colStart = col - col % sqrt;

        for(int r = rowStart; r < rowStart + sqrt; r++) {
            for(int c = colStart; c < colStart + sqrt; c++) {
                if(board[r][c] == num) {
                    return false;
                }
            }
        }

        return true;
    }
}
