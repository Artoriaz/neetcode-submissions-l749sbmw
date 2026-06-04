class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return dfs(dp, 0, n);
    }
    public int dfs(int[] dp, int step, int goal) {
        if(step >= goal) return step == goal ? 1 : 0;
        if(dp[step] != -1) return dp[step];
        return dp[step] = dfs(dp, step +1, goal) + dfs(dp, step+2, goal);
    }
}
