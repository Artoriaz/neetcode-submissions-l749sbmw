class Solution {
    public int coinChange(int[] coins, int amount) {
        Integer[][] cache = new Integer[coins.length+1][amount+1];
        
        int min = dfs(0,amount , coins, cache);
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public int dfs(int i ,int target ,int[] coins , Integer[][] cache) {
        if(target == 0) return 0;
        if(target < 0 ||  i>=  coins.length) return Integer.MAX_VALUE;
        if(cache[i][target] != null ) return cache[i][target];

        int left = dfs(i, target - coins[i], coins, cache);
        if(left != Integer.MAX_VALUE) left++;
        int right = dfs( i+1, target, coins , cache);
        return cache[i][target] = Math.min (left, right);
    }
}