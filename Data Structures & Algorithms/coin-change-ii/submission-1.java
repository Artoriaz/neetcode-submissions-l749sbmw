class Solution {
    public int change(int amount, int[] coins) {
        int[][] cache = new int[coins.length +1][amount +1];
        for(int i = 0; i <= coins.length; i++) cache[i][0] = 1;
        for(int i = 1; i <= coins.length; i++) {
            for(int j = 1 ; j <= amount; j++) {
                if(coins[i-1] <= j) {
                   cache[i][j] =  cache[i][j - coins[i-1]] + cache[i-1][j];
                } else {
                    //skip
                    cache[i][j] = cache[i-1][j];
                }
            }
        }
        return cache[coins.length][amount];
    }
}
