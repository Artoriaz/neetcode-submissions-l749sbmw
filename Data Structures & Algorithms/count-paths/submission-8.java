class Solution {
    public int uniquePaths(int m, int n) {
        //padding trick to make it easier.
        int[][] cache = new int[m+1][n+1];
        cache[m-1][n-1] =1;
        for(int row = m-1; row >=0; row--) {
            for(int col = n-1; col >=0; col--) {
                if(row == m-1 && col == n-1) continue;
                cache[row][col] = cache[row+1][col] + cache[row][col+1];
            }
        }
        return cache[0][0];
    }
}
