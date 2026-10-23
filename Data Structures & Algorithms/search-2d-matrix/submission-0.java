class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int bot = 0;
        int top = matrix.length - 1;

        while (bot <= top) {
            int mid = bot + (top - bot) / 2;

                if (target > matrix[mid][matrix[mid].length-1]) {
                    bot = mid + 1;
                } else if (target < matrix[mid][0]) {
                    top = mid-1;
                } else {
                    int found = bs(matrix[mid], target);
                    if (found != -1)return true;
                    else break;
                      }
        }
         return false;
    }
        

        public int bs(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length-1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] < target) {
                lo = mid + 1; 
            } else if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }


}

