class Solution {
    int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    int ROWS, COLS;
    public class State {
        int row;
        int col;
        public State(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public void solve(char[][] board) {
        ROWS = board.length;
        COLS = board[0].length;

        for(int c = 0; c < COLS ; c++) {
            if(board[0][c] == 'O') {

                board[0][c] = '#';
                bfs(0 , c,board);
            }
            if(board[ROWS-1][c] == 'O') {
                board[ROWS-1][c] = '#';
                bfs(ROWS-1, c , board);
            }
        }

        for(int r =0; r < ROWS ; r++) {
            if(board[r][0] == 'O') {
                board[r][0]= '#';
                bfs(r,0, board);
            }
            if(board[r][COLS-1] == 'O') {
                board[r][COLS-1] = '#';
                bfs(r, COLS-1, board);
            }
        }

        for(int r= 0; r < ROWS ; r++) {
            for(int c = 0 ; c < COLS; c++) {
                if(board[r][c] == '#') board[r][c] = 'O';
                else board[r][c] =  'X';
               
            }
        }
    }
    public void bfs(int row, int col, char[][] board) {
        Queue<State> q= new LinkedList<>();
        q.add(new State(row, col));
        while(!q.isEmpty()) {
            State state = q.poll();
            for(int[] dir: directions) {
                int nRow = dir[0] + state.row;
                int nCol = dir[1] + state.col;
                if(isValid(nRow,nCol , board)) {
                    board[nRow][nCol] = '#';
                    q.add(new State(nRow, nCol));
            }
            }
        }
    }
    public boolean isValid(int row, int col ,char[][] grid) {
        return 0 <= row && row < ROWS && 0<= col && col < COLS && grid[row][col] == 'O';
    }
}
