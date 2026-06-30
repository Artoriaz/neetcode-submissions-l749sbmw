class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        if(n < m) return 0;
        int[][] cache = new int[n+1][m+1];

        //proper seed
        for(int i = 0; i <= n; i++ ){ 
            cache[i][0] = 1;
        }
        for(int i = 1; i<=n; i++) {
            for(int j = 1; j<=m; j++) {
                //skip
                cache[i][j] += cache[i-1][j];
                if(s.charAt(i-1) == t.charAt(j-1)) {
                    //take 
                    cache[i][j] += cache[i-1][j-1];
                }
            }
        }
        return cache[n][m];
    }
}
