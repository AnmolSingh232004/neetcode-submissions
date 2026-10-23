class Solution {
    public int rob(int[] nums) {
        int[] cache = new int[nums.length];
        for (int i=0; i<cache.length; i++) {
            cache[i] = -1;
        }
        return dfs(nums, 0, cache);
        
    }

    public int dfs(int[] nums, int i, int[] cache) {
        if (i >= nums.length)return 0;
        if (cache[i] != -1)return cache[i];

        int loot = nums[i] + dfs(nums, i+2, cache);
        int skip = dfs(nums, i+1, cache);

        int totalRobbed = Math.max(loot, skip);
        cache[i] = totalRobbed;

        return cache[i];
    }
}

// two options
// rob current skip next
// skip current rob next