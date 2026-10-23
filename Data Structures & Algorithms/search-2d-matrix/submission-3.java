class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int ROWS = matrix.length;
        int COLS = matrix[0].length;

        int top = 0;
        int bot = ROWS - 1;

        while(top <= bot){
             int row = top + (bot - top)/2;

             if(target > matrix[row][COLS - 1] ){
                top = row + 1;
             }
             else if(target < matrix[row][0]){
                bot = row - 1;
             }
             else{
                break;
             }
        }

        int row = top + (bot - top)/2; // row our answer should be in
        int lo = 0;
        int hi = COLS - 1;


        while(lo <= hi){
            int mid = lo + (hi - lo)/2;

            if(row < matrix.length && matrix[row][mid] == target){
            return true;
            }
            else if(row < matrix.length && matrix[row][mid] < target){
                lo = mid + 1;
            }
            else{
                hi = mid - 1;
            }
        }

        return false;
    }
}