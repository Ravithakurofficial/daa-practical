public class NQueens {

    public static void main(String[] args) {
        int n = 8; // You can change this to any positive integer for an N×N board
        solveNQueens(n);
    }

    public static void solveNQueens(int n) {
        int[][] board = new int[n][n];

        if (solveNQueensUtil(board, 0, n)) {
            printSolution(board);
        } else {
            System.out.println("No solution exists.");
        }
    }

    private static boolean solveNQueensUtil(int[][] board, int col, int n) {
        if (col == n) {
            return true; // All queens are placed successfully
        }

        for (int i = 0; i < n; i++) {
            if (isSafe(board, i, col, n)) {
                board[i][col] = 1;

                if (solveNQueensUtil(board, col + 1, n)) {
                    return true; // Recur to place rest of the queens
                }

                board[i][col] = 0; // If placing queen in the current position doesn't lead to a solution, backtrack
            }
        }

        return false; // If no row is found to place the queen, backtrack
    }

    private static boolean isSafe(int[][] board, int row, int col, int n) {
        // Check this row on left side
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        // Check upper diagonal on left side
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // Check lower diagonal on left side
        for (int i = row, j = col; i < n && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    private static void printSolution(int[][] board) {
        for (int[] row : board) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
