class Solution {
    public boolean isValidSudoku(char[][] board) {

        // check each row
        for (int i = 0; i < 9; i++) {
            Set<Character> seen = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;      // skip empty cells
                if (seen.contains(board[i][j])) return false; // duplicate in row
                seen.add(board[i][j]);
            }
        }

        // check each column
        for (int i = 0; i < 9; i++) {
            Set<Character> seen = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[j][i] == '.') continue;      // skip empty cells
                if (seen.contains(board[j][i])) return false; // duplicate in column
                seen.add(board[j][i]);
            }
        }

        // check each 3x3 sub-boxs since there will be 9 sub boxes
        for (int square = 0; square < 9; square++) {
            Set<Character> seen = new HashSet<>();

            // iterate inside current 3x3 box
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {

                    // compute actual row and column
                    int row = (square % 3) * 3 + i;
                    int col = (square / 3) * 3 + j;

                    if (board[row][col] == '.') continue;      // skip empty cells
                    if (seen.contains(board[row][col])) return false; // duplicate in box
                    seen.add(board[row][col]);
                }
            }
        }

        // all checks passed
        return true;
    }
}
