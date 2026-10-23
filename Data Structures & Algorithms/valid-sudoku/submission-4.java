class Solution {
    public boolean isValidSudoku(char[][] board) {

        for (int i=0; i<9; i++) {
            Set<Character> seenRow = new HashSet<>();
            for (int j=0; j<9; j++) {
                if (board[i][j] == '.')continue;
                if (seenRow.contains(board[i][j]))return false;
                seenRow.add(board[i][j]);
            }
        }

            for (int i=0; i<9; i++) {
            Set<Character> seenCol = new HashSet<>();
            for (int j=0; j<9; j++) {
                if (board[j][i] == '.')continue;
                if (seenCol.contains(board[j][i]))return false;
                seenCol.add(board[j][i]);
            }
        }

        // making 0,1,2 = 0 || 3,4,5 = 1 || 6,7,8 = 2

        for (int square=0; square<9; square++) { //1 square gets one whole loop
        Set<Character> seenBox = new HashSet<>();
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                int rowIndex = (square / 3) * 3 + row;
// for square = 2 || 2/3 = 0 || 0 * 3 = 0 || = 0 ||this value stays constant for whole operation
// row changes 3 times to itterate over all elements from top to bottom of box
                int colIndex = (square % 3) * 3 + col;
//same thing just % instead of divide because mod gives columns 0,1,2 from 0 digits
                if (board[rowIndex][colIndex] == '.')continue; 
                if (seenBox.contains(board[rowIndex][colIndex]))return false;
                seenBox.add(board[rowIndex][colIndex]);
            }
        }
        }
        return true;
    }
}
