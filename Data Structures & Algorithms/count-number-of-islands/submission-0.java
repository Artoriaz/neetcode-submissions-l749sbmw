class Solution {
    int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    boolean[][] visited;
    int islands = 0;
    int colLength;
    int rowLength;
    public int numIslands(char[][] grid) {
        rowLength = grid.length;
        colLength = grid[0].length;

        visited = new boolean[rowLength][colLength];
        for(int i = 0; i < rowLength; i++){
            for(int j = 0; j <colLength; j++) {
                if(!visited[i][j] && grid[i][j] == '1') {
                    islands++;
                    visited[i][j] = true;
                    dfs(i, j, grid);
                }
            }
        }

        return islands;
    }
    public void dfs(int row, int col, char[][] grid) {
        for(int[] dir: directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if(isValid(newRow,newCol, grid) && !visited[newRow][newCol]) {
                visited[newRow][newCol] = true;
                dfs(newRow,newCol, grid);
            }
        }
    }
    public boolean isValid(int row, int col, char[][] grid) {
        return 0 <= row && row < rowLength && 0 <= col && col < colLength && grid[row][col] == '1';
    }
}
