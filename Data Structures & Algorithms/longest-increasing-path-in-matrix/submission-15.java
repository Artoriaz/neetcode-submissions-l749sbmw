class Solution {
    int[][] cache;
    int ROWS;
    int COLS;
    int[][] directions = {{1,0}, {-1,0} , {0, 1}, {0,-1}};
    public int longestIncreasingPath(int[][] matrix) {
        ROWS = matrix.length;
        COLS = matrix[0].length;
        cache = new int[ROWS][COLS];
        for(int[] c: cache) {
            Arrays.fill(c, -1);
        }
        int LIS = 1;
        for(int i=0; i < ROWS; i++) {
            for(int j = 0 ; j < COLS ; j++) {
                LIS = Math.max(LIS , dfs(i,j, matrix));
            }
        }
        return LIS;

    }
    public int dfs(int row , int col, int[][] matrix) {
        if(cache[row][col] != -1) return cache[row][col];

        int maxLength = 1;
        for(int[] dir: directions) {
            int newRow = row + dir[0];
            int newCol =col + dir[1];
            if(isValid(newRow, newCol) && matrix[row][col] < matrix[newRow][newCol]) {
                maxLength  = Math.max(maxLength, 1 + dfs(newRow, newCol, matrix));
            }
        }

        return cache[row][col] = maxLength;
    }
    public boolean isValid(int row, int col) {
        return 0<= row && row < ROWS && 0<= col && col < COLS;
    }  
}
