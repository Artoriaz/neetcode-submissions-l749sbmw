class Solution {
    int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    int ROWS, COLS;
    boolean[][] markedEdges;
    char[][] marker; 
    public void solve(char[][] board) {
        ROWS = board.length;
        COLS = board[0].length;
        markedEdges = new boolean[ROWS][COLS];
        marker = new char[ROWS][COLS];

        for(int c= 0; c < COLS; c++) {
            if(board[0][c] == 'O') dfs(0, c, board);
            if(board[ROWS-1][c] == 'O')  dfs(ROWS-1, c, board);

        }
        for(int r = 0; r < ROWS ; r++) {
            if(board[r][COLS-1] == 'O') dfs(r, COLS-1, board);
            if(board[r][0] == 'O')  dfs(r, 0, board);
                
        }

        for(int i = 0 ; i < ROWS; i++) {
            for(int j = 0; j < COLS ; j++) {
                if(marker[i][j] != '#') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(int row, int col, char[][] board) {
        markedEdges[row][col] = true;
        marker[row][col] = '#';
        for(int[] dir: directions) {
            int nRow = dir[0] + row;
            int nCol = dir[1] + col;
            if(isValid(nRow, nCol, board) && !markedEdges[nRow][nCol]) {  
                    
                    dfs(nRow,nCol, board);
            }
        }
    }
    public boolean isValid(int row, int col, char[][] grid) {
        return 0 <= row && row < ROWS && 0 <= col && col < COLS && grid[row][col] == 'O';
    }
}
