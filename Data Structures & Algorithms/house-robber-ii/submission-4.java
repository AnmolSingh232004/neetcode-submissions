class Solution {
    int[] cache1;
    int[] cache2;
    public int rob(int[] nums) {
        if (nums.length == 1)return nums[0];
        cache1 = new int[nums.length+1]; // Seperate caches for both cases
        cache2 = new int[nums.length+1];
        for (int i=0; i<cache1.length; i++) {
            cache1[i] = -1;
            cache2[i] = -1;
        }

        int excludeFirst = dfs(nums, 1, nums.length, cache1);
        int excludeLast = dfs(nums, 0, nums.length-1, cache2);

        return Math.max(excludeFirst, excludeLast);

    }

    public int dfs(int[] nums, int i, int limit, int[] localCache) {
        if (i >= limit)return 0;
        if (localCache[i] != -1)return localCache[i];

        int rob = nums[i] + dfs(nums, i+2, limit, localCache);
        int skip = dfs(nums, i+1, limit, localCache);

        localCache[i] = Math.max(rob, skip);
        return localCache[i];
    }
}

// if we rob first house we cant rob last house
// if we rob last house we cant rob first house