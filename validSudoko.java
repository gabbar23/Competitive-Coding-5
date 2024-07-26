import java.util.HashSet;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        int N = 9; // Size of the Sudoku board is 9x9

        // Use boolean arrays to record the status of rows, columns, and blocks
        boolean[][] rows = new boolean[N][N]; // rows[i][j] will be true if number (j+1) is in row i
        boolean[][] cols = new boolean[N][N]; // cols[i][j] will be true if number (j+1) is in column i
        boolean[][] blocks = new boolean[N][N]; // blocks[i][j] will be true if number (j+1) is in block i

        // Iterate over each cell in the board
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                char val = board[row][col]; // Get the value at the current cell

                // Check if the position is filled with a number
                if (val == '.') {
                    continue; // Skip empty cells
                }

                // Calculate the position index for the current number (1-9) as 0-8
                int position = val - '1';

                // Check the row
                if (rows[row][position] == true) {
                    return false; // If the number already exists in the row, return false
                }
                rows[row][position] = true; // Mark the number as seen in the row

                // Check the column
                if (cols[col][position] == true) {
                    return false; // If the number already exists in the column, return false
                }
                cols[col][position] = true; // Mark the number as seen in the column

                // Check the block
                int blockIndex = (row / 3) * 3 + col / 3; // Calculate the block index based on row and column
                if (blocks[blockIndex][position] == true) {
                    return false; // If the number already exists in the block, return false
                }
                blocks[blockIndex][position] = true; // Mark the number as seen in the block
            }
        }
        return true; // If no duplicates are found, return true
    }
}
