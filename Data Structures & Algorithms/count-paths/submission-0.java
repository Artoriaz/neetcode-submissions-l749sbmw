class Solution {
    int r, c;
    Integer[][] cache;
    public int uniquePaths(int m, int n) {
        r = m -1;
        c = n -1;
        cache = new Integer[m][n];
        return dfs(0, 0);
        
    }
    public int dfs(int m, int n) {
        if(m == r && n == c) return 1;
        if(cache[m][n] != null) return cache[m][n];
        //go right hit max
        cache[m][n] = 0;
        if(m != r) {
             cache[m][n] += dfs(m+1, n);
        }
        if(n != c) {
            // go down
             cache[m][n] += dfs(m, n +1);
        }
        return cache[m][n];
        
    }
}
