class Solution {
    int r, c;
    Integer[][] cache;
    public int uniquePaths(int m, int n) {
        r = m -1;
        c = n -1;
        cache = new Integer[m][n];
        return dfs(0, 0);
        
    }
    public int dfs(int row, int col) {
        if(row == r && col == c) return 1;
        if(cache[row][col] != null) return cache[row][col];
        //go right hit max
        cache[row][col] = 0;
        if(row != r) {
            //go down
             cache[row][col] += dfs(row+1, col);
        }
        if(col!= c) {
            //go right
             cache[row][col] += dfs(row, col +1);
        }
        return cache[row][col];
        
    }
}
