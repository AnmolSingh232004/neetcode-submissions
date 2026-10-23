class Solution {
    int[] cache;
    public int minCostClimbingStairs(int[] cost) {
        cache = new int[cost.length+1];
        for (int i=0; i<=cost.length; i++) {
            cache[i] = -1;
        }
        int one = dfs(cost, 0);
        int two = dfs(cost, 1);
        return Math.min(one, two);
    }

    public int dfs(int[] cost, int i) {
        if (i >= cost.length)return 0;
        if (cache[i] != -1)return cache[i];

        int one = dfs(cost, i+1);
        int two = dfs(cost, i+2);

        cache[i] = cost[i] + Math.min(one, two);
        return cost[i] + Math.min(one, two);
    }
}
