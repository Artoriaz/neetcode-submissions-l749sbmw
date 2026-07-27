class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        Integer[][] cache = new Integer[n +1][amount +1];

        return dfs(0,amount, cache, coins);
    }
    public int dfs(int i, int target, Integer[][] cache, int[] coins){
        if(i >= coins.length) return target == 0 ? 1 : 0;
        if(target == 0) return 1;
        if(target < 0) return 0;
        if(cache[i][target] != null) return cache[i][target];
        //TAKE OR SKIP
        return cache[i][target] = dfs(i, target-coins[i], cache, coins) + dfs(i+1, target, cache, coins);
    }
}
