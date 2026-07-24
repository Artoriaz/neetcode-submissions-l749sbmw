class Solution {
    public int coinChange(int[] coins, int amount) {
        Integer[][] cache = new Integer[coins.length+1][amount+1];

         int min =  dfs(0, coins, amount, cache);
         return min >= Integer.MAX_VALUE ? -1 : min;

    
    }
    //guard for less and going over I 
    public int dfs(int i , int[] coins , int target, Integer[][] cache) {
        if(i >= coins.length || target < 0) return Integer.MAX_VALUE; 
        if(target == 0) return 0;
        if(cache[i][target] != null) return cache[i][target];
        //take or skip
        int left =  dfs( i, coins , target - coins[i], cache);
         if(left != Integer.MAX_VALUE) left = left + 1;
        int right = dfs(i+1, coins, target, cache);

        return cache[i][target]= Math.min(left,right);
    }
}