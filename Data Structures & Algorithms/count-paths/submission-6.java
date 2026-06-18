class Solution {
    int r, c;
    public int uniquePaths(int m, int n) {
        r = m-1;
        c = n-1;
        Integer[][] cache = new Integer[m][n];
        return dfs(0,0, cache);
    }
    public int dfs(int row, int col,Integer[][] cache) {
        if(row == r && col == c) return 1;
        if(row > r || col > c) return 0;
        if(cache[row][col] != null) return cache[row][col];

        return cache[row][col] = dfs(row+1, col, cache) + dfs(row, col+1, cache);
    }
}
