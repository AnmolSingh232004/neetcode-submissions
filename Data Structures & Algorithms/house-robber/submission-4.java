class Solution {
    int[] cache;
    public int rob(int[] nums) {
        cache = new int[nums.length+1];
        for (int i=0; i<nums.length; i++) {
            cache[i] = -1;
        }
        return dfs(nums, 0);
    }

    public int dfs(int[] nums, int i) {
        if (i >= nums.length)return 0;
        if (cache[i] != -1)return cache[i];


        int loot = nums[i] + dfs(nums, i+2);
        int skip = dfs(nums, i+1);

        cache[i] = Math.max(skip, loot);

        return Math.max(skip, loot);
    }
}
