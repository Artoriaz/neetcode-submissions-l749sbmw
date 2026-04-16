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
            if(board[0][c] == 'O'){
                    markedEdges[0][c] = true;
                    marker[0][c] = '#';
                    dfs(0, c, board);
            }
            if(board[ROWS-1][c] == 'O'){
                    markedEdges[ROWS-1][c] = true;
                    marker[ROWS-1][c] = '#';
                dfs(ROWS-1, c, board);
            }

        }
        for(int r = 0; r < ROWS ; r++) {
            if(board[r][COLS-1] == 'O') {
                markedEdges[r][COLS-1] = true;
                marker[r][COLS-1] = '#';
                dfs(r, COLS-1, board);
            }
            if(board[r][0] == 'O') {
                markedEdges[r][0] = true;
                marker[r][0] = '#';
                dfs(r, 0, board);
            }
                
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
        
        for(int[] dir: directions) {
            int nRow = dir[0] + row;
            int nCol = dir[1] + col;
            if(isValid(nRow, nCol, board) && !markedEdges[nRow][nCol]) {
                    markedEdges[nRow][nCol] = true;
                    marker[nRow][nCol] = '#'; 
                    dfs(nRow,nCol, board);
            }
        }
    }
    public boolean isValid(int row, int col, char[][] grid) {
        return 0 <= row && row < ROWS && 0 <= col && col < COLS && grid[row][col] == 'O';
    }
}
