class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] cache = new int[n];
        Arrays.fill(cache, -1);

        return Math.min(dfs(cache, 0, n, cost), dfs(cache, 1, n, cost));
    }
    public int dfs(int[] cache, int i, int n, int[] cost) {
        if(i >= n) return 0;
        if(cache[i] != -1) return cache[i];
        return cache[i] = cost[i] + Math.min(dfs(cache, i+1, n, cost), dfs(cache, i+2, n, cost));
    }
}
