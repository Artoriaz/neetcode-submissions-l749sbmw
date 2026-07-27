class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] balloons = new int[n+2];
        balloons[0] = 1; balloons[n+1] = 1;
        for(int i = 0; i< n; i++) balloons[i+1] = nums[i];

        Integer[][] cache = new Integer[n+2][n+2];
        return dfs(1, balloons.length-2, balloons, cache);
    }
    public int dfs(int left, int right, int[] balloons, Integer[][] cache) {
        if(left > right ) return 0;
        if(cache[left][right] != null) return cache[left][right];

        cache[left][right] = 0;
        for(int k = left; k<= right; k++) {
            int coins = balloons[left-1] * balloons[k] * balloons[right+1] + 
                dfs(left, k -1, balloons, cache) + dfs(k+1, right, balloons, cache);
                cache[left][right] = Math.max(cache[left][right], coins);
           
        }

       return  cache[left][right];
    }
}
