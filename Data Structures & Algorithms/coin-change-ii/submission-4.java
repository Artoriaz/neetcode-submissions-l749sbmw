class Solution {
    public int change(int amount, int[] coins) {
     Integer[][] cache = new Integer[coins.length+1][amount+1];

     return dfs(0, amount, coins, cache);
    }
    public int dfs(int i, int target,int[] coins,  Integer[][] cache) {
        if( i >= coins.length || target < 0) return 0;
        if(target == 0)return 1;
        if(cache[i][target] != null) return cache[i][target];

        return cache[i][target] = dfs(i, target - coins[i], coins, cache) + 
        dfs(i+1, target, coins, cache);
    }
}
