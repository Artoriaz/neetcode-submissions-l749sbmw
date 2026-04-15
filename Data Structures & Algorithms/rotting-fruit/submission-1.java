class Solution {
    
    int[][] directions = {{0,1}, {0, -1}, {1,0}, {-1,0}};
    int ROWS, COLS;
    public class State {
        int col;
        int row;
        public State(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public int orangesRotting(int[][] grid) {
        Queue<State> q = new LinkedList<>();
        ROWS = grid.length;
        COLS = grid[0].length;
        boolean[][] visited = new boolean[ROWS][COLS];
        // insert any rotten fruits
        for(int i = 0; i < ROWS; i++) {
            for(int j =0; j < COLS; j++) {
                if(!visited[i][j] && grid[i][j] == 2) {
                    visited[i][j] = true;
                    q.add(new State(i,j));
                }
            }
        }
        int minutes = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i= 0 ; i < size; i++) {
                State state = q.poll();

                for(int[] dir: directions) {
                    int newRow = dir[0] + state.row;
                    int newCol = dir[1] + state.col;
                    if(isValid(newRow,newCol, grid) && !visited[newRow][newCol]) {
                        visited[newRow][newCol] = true;
                        grid[newRow][newCol] = 2;
                        q.add(new State(newRow,newCol));
                    }
                }
            }
            if(!q.isEmpty()) {
                 minutes++;
            }
           
        }
        for(int i =0 ; i <ROWS; i++) {
            for(int j= 0; j < COLS ; j++) {
                if(grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return minutes;

        //recheck visited array, if an
        // after bfs
        // to check grid if all fruits are rotten.
        //if one is not return -1 , else return minutes.
    }
    public boolean isValid(int row, int col, int[][] grid)  {
        return 0 <= row && row < ROWS && 0 <= col && col < COLS && grid[row][col] == 1;
    }
}
