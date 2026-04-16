class Solution {
    int[][] directions = {{0,1} , {0,-1}, {1,0}, {-1,0}};
    int ROWS, COLS;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> answer = new ArrayList<>();
        ROWS = heights.length;
        COLS = heights[0].length;
        boolean[][] atlantic = new boolean[ROWS][COLS];
        boolean[][] pacific = new boolean[ROWS][COLS];

        for(int c = 0; c < COLS ; c++) {
            dfs(0, c, pacific, heights);
            dfs(ROWS -1, c, atlantic, heights);
        }

        for(int r = 0; r < ROWS ; r++){
            dfs(r, 0, pacific, heights);
            dfs(r, COLS -1, atlantic, heights);
        }

        for(int i = 0; i < ROWS; i++) {
           for(int j = 0; j< COLS; j++) {
                if(atlantic[i][j] == true && pacific[i][j] ==true) {
                    answer.add(new ArrayList<>(Arrays.asList(i,j)));
                }
           } 
        }
        return answer;

    }
    public void dfs(int row, int col, boolean[][] ocean, int[][] grid) {
        ocean[row][col] = true;
        for(int[] dir: directions) {
            int newRow = dir[0] + row;
            int newCol = dir[1] + col;
            if(isValid(newRow,newCol, grid, grid[row][col]) && !ocean[newRow][newCol]) {
                dfs(newRow,newCol, ocean, grid);
            }
        }
    }

    public boolean isValid(int row, int col, int[][] grid, int oldValue) {
       return 0 <= row && row < ROWS && 0 <= col && col < COLS && grid[row][col] >= oldValue;
    }
}
