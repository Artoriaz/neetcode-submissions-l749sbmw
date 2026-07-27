class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] b = new int[n+2];
        b[0] =1; b[n+1] = 1;
        for(int i=0; i<n; i++) b[i+1] = nums[i];

        Integer[][] cache = new Integer[n+2][n+2];

        return dfs(0, n+1, cache, b);
    }
    public int dfs(int left, int right, Integer[][] cache, int[] coins) {
        if(right - left < 2) return 0;
        if(cache[left][right] != null) return cache[left][right];
        int best = 0;
        for(int k = left +1; k< right; k++) {
            int coin = coins[left] * coins[k] * coins[right] +
            dfs(left, k, cache, coins) + dfs(k, right, cache, coins);
            best = Math.max(coin,best);
        }
        return cache[left][right] = best;
    }
}
