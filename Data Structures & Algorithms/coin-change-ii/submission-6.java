class Solution {
    public int change(int amount, int[] coins) {
     int n = coins.length;
     int m = amount;
     int[][] cache = new int[n+1][m+1];

     //base  seeding
     for(int i= 0; i<=n; i++) {
        cache[i][0] = 1;
     }
     for(int i = 1; i<=n; i++) {
        for(int j=1; j<=m; j++) {
            cache[i][j] = cache[i-1][j];
            if(coins[i-1] <= j){
                cache[i][j] += cache[i][j-coins[i-1]]; 
            }       
     }  
    }
    return cache[n][m];  
}
}
