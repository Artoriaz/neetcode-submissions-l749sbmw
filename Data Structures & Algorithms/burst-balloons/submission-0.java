class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] balloons = new int[n+2];
        balloons[0] = 1; balloons[n+1] = 1;
        for(int i = 0; i< n; i++) balloons[i+1] = nums[i];

        Integer[][] cache = new Integer[n+2][n+2];
        return dfs(0, n+1, balloons, cache);
    }
    public int dfs(int left, int right, int[] balloons, Integer[][] cache) {
        if(right - left < 2 ) return 0;
        if(cache[left][right] != null) return cache[left][right];

        int best = 0;
        for(int k = left +1; k< right; k++) {
            int coins = balloons[left] * balloons[k] * balloons[right] + 
                dfs(left, k, balloons, cache) + dfs(k, right, balloons, cache);

            best = Math.max(best, coins);
        }

       return  cache[left][right] = best;
    }
}
