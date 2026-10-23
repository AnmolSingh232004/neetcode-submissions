class Solution {
    int minCost = Integer.MAX_VALUE;
    public int minCostClimbingStairs(int[] cost) {
        int[] cache = new int[cost.length+1];
        for (int i=0; i<cache.length; i++) {
            cache[i] = -1;
        }
        int first = dfs(cost, 0, 0, cache);
        int second = dfs(cost, 1, 0, cache);
        return Math.min(first, second);
    }

    public int dfs(int[] cost, int i, int totalCost, int[] cache) {
        if (i < cost.length && cache[i] != -1) {
            return cache[i];
        }
        if (i >= cost.length) {
        return 0;
        }
        
        int one = dfs(cost, i+1, totalCost + cost[i], cache);
        int two = dfs(cost, i+2, totalCost + cost[i], cache);

        cache[i] = cost[i] + Math.min(one, two);

        return cache[i];
    }
}
