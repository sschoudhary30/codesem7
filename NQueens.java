import java.util.Scanner;

public class NQueens {

    // Print the chessboard with queens placed
    private static void printSolution(int[][] board, int N) {
        for (int[] row : board) {
            for (int cell : row) {
                System.out.print(cell == 1 ? "Q " : "_ ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Check if placing a queen at board[row][col] is safe
    private static boolean isSafe(int[][] board, int row, int col, int N) {
        for (int i = 0; i < col; i++) // Check row on left side
            if (board[row][i] == 1) return false;

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) // Check upper diagonal
            if (board[i][j] == 1) return false;

        for (int i = row, j = col; i < N && j >= 0; i++, j--) // Check lower diagonal
            if (board[i][j] == 1) return false;

        return true;
    }

    // Solve N-Queens using backtracking and print only the first solution
    private static boolean solveNQueens(int[][] board, int col, int N) {
        if (col == N) {
            printSolution(board, N); // Print the first solution
            return true; // Return true to stop further searching
        }

        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col, N)) {
                board[i][col] = 1; // Place queen
                if (solveNQueens(board, col + 1, N)) // Stop if a solution is found
                    return true;
                board[i][col] = 0; // Backtrack
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the board: ");
        int N = scanner.nextInt();
        scanner.close();

        int[][] board = new int[N][N];
        if (!solveNQueens(board, 0, N)) {
            System.out.println("No solution exists.");
        }
    }
}
