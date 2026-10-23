class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];

        for (int i=1; i<nums.length; i++) {
            prefix[i] = nums[i] * prefix[i-1];
        }

        int[] postfix = new int[nums.length];
        postfix[nums.length-1] = nums[nums.length-1];

        for (int i=nums.length-2; i >= 0; i--) {
            postfix[i] = postfix[i+1] * nums[i];
        }

        for (int i=0; i<nums.length; i++) {
            if (i == 0)nums[i] = postfix[i+1];
            if (i == nums.length-1)nums[i] = prefix[i-1];
            if (i != 0 && i != nums.length-1)nums[i] = postfix[i+1] * prefix[i-1];
        }
        return nums;
    }
}  


// [1,2,4,6] array
// [1,2,8,48] prefix

// [1,2,4,6] array
// [48,48,24,6] postfix