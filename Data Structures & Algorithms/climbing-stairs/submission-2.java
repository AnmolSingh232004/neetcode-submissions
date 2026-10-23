class Solution {
    int[] cache;
    public int climbStairs(int n) {
        cache = new int[n+1];
        for (int i=0; i<n; i++) {
            cache[i] = -1;
        }
        
        return dfs(n, 0);
    }

    public int dfs(int n, int curr) {
        if (curr > n)return 0;
        if (curr == n)return 1;
        if (cache[curr] != -1)return cache[curr];
        
        int left = dfs(n, curr+1);
        int right = dfs(n, curr+2);
        cache[curr] = left + right;

        return cache[curr];
    }
}