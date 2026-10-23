class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1)return nums[0];
        int[] cache = new int[nums.length];
        for (int i=0; i<cache.length; i++) {
            cache[i] = -1;
        }
        int firstSkip = dfs(nums, 1, nums.length, cache);
        for (int i=0; i<cache.length; i++) {
            cache[i] = -1;
        }
        int lastSkip = dfs(nums, 0, nums.length-1, cache);

        return Math.max(firstSkip, lastSkip);
    }

    public int dfs(int[] nums, int i, int last, int[] cache) {
        if (i >= last)return 0;
        if (cache[i] != -1)return cache[i];

        int loot = nums[i] + dfs(nums, i+2, last, cache);
        int skip = dfs(nums, i+1, last, cache);

        int maxLoot = Math.max(loot, skip);
        cache[i] = maxLoot;

        return cache[i];
    }
}

// in first case how about we skip first house
// in second case how about we skip last house
