class Solution {
    int ROWS, COLS;
    int[][] directions = {{0,1}, {0, -1}, {1,0} , {-1,0}};
    List<List<Integer>> answer;
    public class State {
        int row;
        int col; 
        public State(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        ROWS = heights.length;
        COLS = heights[0].length;
        answer = new ArrayList<>();

        for(int i = 0; i < ROWS; i++) {
            for(int j = 0; j < COLS ; j++) {
                if(bfs(i, j, heights) == true) {
                    answer.add(new ArrayList(Arrays.asList(i,j)));
                }
            }
        }

        return answer;
    }
    public boolean bfs(int row, int col, int[][] grid) {
        Queue<State> q = new LinkedList<>();
        boolean[][] visited = new boolean[ROWS][COLS];
        boolean atl = false;
        boolean pac = false;
    
        if(pacificCheck(row, col) && atlanticCheck(row,col)) {
            atl = true;
            pac = true;
            //pacific check
        } else if(pacificCheck(row, col)) {
            pac= true;
            
        } else if(atlanticCheck(row, col)) {
           atl = true;
        } 
        q.add(new State(row,col));

        visited[row][col] = true;

        while(!q.isEmpty()) {
            State state = q.poll();
            if(pac== true && atl == true) {
                return true;
            }
            for(int[] dir: directions) {
                int newRow = dir[0] + state.row;
                int newCol = dir[1] + state.col;
                if(isValid(newRow,newCol, grid, grid[state.row][state.col]) && !visited[newRow][newCol]) {
                    if(atlanticCheck(newRow, newCol) && pacificCheck(newRow,newCol)) {
                        atl = true;
                        pac = true;
                    } else if(pacificCheck(newRow,newCol)) {
                        pac = true;
                    } else if(atlanticCheck(newRow,newCol)) {
                        atl = true;
                    }
                    q.add(new State(newRow, newCol));
                    visited[newRow][newCol] = true;
                }
            }
        }
        return false;
    }
    public boolean pacificCheck(int row, int col) {
        return row == 0 || col == 0;
    }

    public boolean atlanticCheck(int row, int col) {
        return row == ROWS-1 || col == COLS -1;
    }
    public boolean isValid(int row, int col, int grid[][], int value) {
        return 0 <= row && row < ROWS && 0 <= col  && col < COLS && grid[row][col] <= value;
    }
}
