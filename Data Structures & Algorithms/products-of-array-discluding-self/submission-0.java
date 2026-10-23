class Solution {
    public int[] productExceptSelf(int[] nums) {

        int[] res = new int[nums.length];

        for (int i=0; i<nums.length; i++) {
            int localSum = 1;
            for (int j=0; j<nums.length; j++) {
                if (j==i)continue;
                localSum *= nums[j];
            }
            res[i] = localSum;
        }
        return res;
    }
}  
