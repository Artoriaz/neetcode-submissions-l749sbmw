class Solution {
    public int change(int amount, int[] coins) {
     Integer[][] cache = new Integer[coins.length+1][amount+1];

     return dfs(0, 0, coins, amount, cache);
    }
    public int dfs(int i,int currSum, int[] coins, int target, Integer[][] cache) {
        if( i >= coins.length || currSum > target) return 0;
        if(currSum == target)return 1;
        if(cache[i][currSum] != null) return cache[i][currSum];

        return cache[i][currSum] = dfs(i, currSum + coins[i], coins, target, cache) + 
        dfs(i+1, currSum, coins, target, cache);
    }
}
