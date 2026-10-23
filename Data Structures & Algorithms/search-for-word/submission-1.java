class Solution {
    public boolean exist(char[][] board, String word) {
        boolean res = false;
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[i].length; j++) {
                if (board[i][j] == word.charAt(0))
                res = dfs(board, word, i, j, 0);

                if (res)return true;
            }
            
        }
        return res;
    }

    public boolean dfs(char[][] board, String word, int i, int j, int wordIndex) {
        if (wordIndex == word.length())return true;
        if (i < 0 || j < 0 || i >= board.length || j >= board[i].length )return false;

        if (board[i][j] != word.charAt(wordIndex))return false;

        char temp = board[i][j];
        wordIndex = wordIndex + 1;
        board[i][j] = '?';

        boolean found = ( dfs(board, word, i+1, j, wordIndex) || dfs(board, word, i-1, j, wordIndex) ||dfs(board, word, i, j+1, wordIndex) ||dfs(board, word, i, j-1, wordIndex) );

        board[i][j] = temp;

        return found;
    }  
}
