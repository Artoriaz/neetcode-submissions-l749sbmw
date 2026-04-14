class Solution {
    int maxArea=0;
    int rowLength;
    int colLength;
    boolean[][] visited;
    int[][] directions = {{0,1}, {0, -1}, {1, 0}, {-1,0}};
    public int maxAreaOfIsland(int[][] grid) {
        rowLength = grid.length;
        colLength = grid[0].length;
        visited = new boolean[rowLength][colLength];

        for(int i =0; i < rowLength; i++) {
            for(int j = 0; j < colLength; j++){ 
                if(!visited[i][j] && grid[i][j] == 1) {
                    visited[i][j] = true;
                    int size = dfs(i, j, grid);
                    maxArea = Math.max(size,maxArea);
                }
            }
        }
        return maxArea;
    }
    public int dfs(int row, int col, int[][] grid) {
         int currentSize = 1;
        for(int[] dir: directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if(isValid(newRow, newCol, grid) && !visited[newRow][newCol]) {
         
                visited[newRow][newCol] = true;
               
                currentSize +=dfs(newRow,newCol, grid);
            }
        }
        return currentSize;
    }
    public boolean isValid(int row, int col, int[][] grid) {
        return 0 <= row && row < rowLength && 0 <= col && col < colLength && grid[row][col] == 1;
    }
}
