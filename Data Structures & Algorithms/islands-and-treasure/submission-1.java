class Solution {
    private int[][] directions = {{1, 0}, {-1, 0},
                                  {0, 1}, {0, -1}};
    private int INF = 2147483647;
    private int ROWS, COLS;
    public class State {
        int row; 
        int col;
        int steps; 
        public State(int row, int col, int steps) {
            this.row = row;
            this.col = col;
            this.steps= steps;
        }
    }
    public void islandsAndTreasure(int[][] grid) {
        ROWS = grid.length;
        COLS =  grid[0].length;
        for(int i = 0; i < ROWS; i++) {
            for(int j = 0; j< COLS ; j++) {
                if (grid[i][j] == INF) {
                    grid[i][j] = bfs(grid, i, j);
                    }
            }
        }
    }

    public int bfs(int[][] grid, int r, int c) {
        Queue<State> queue = new LinkedList<>();
        boolean[][] visited = new boolean[ROWS][COLS];
        visited[r][c] = true;
        queue.add(new State(r, c, 0));

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                State state = queue.poll();
                for(int[] dir: directions) {
                    int row = state.row + dir[0];
                    int col = state.col + dir[1];
                    
                    if(isValid(row, col, grid) && !visited[row][col]) {
                        if(grid[row][col] == 0) return state.steps +1;
                        visited[row][col] = true;
                        queue.add(new State(row, col, state.steps +1));
                    }
                }
            }
        }


        // if we get do not find exit case;
        return INF;
    }
    public boolean isValid(int row, int col , int[][] grid) {
        return 0 <= row && row < ROWS && 0 <= col && col < COLS && grid[row][col] != -1;
    }
}
