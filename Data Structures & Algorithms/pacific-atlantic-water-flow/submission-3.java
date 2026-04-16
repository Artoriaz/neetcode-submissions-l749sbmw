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
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> answer =new ArrayList<>();
         ROWS =heights.length;
         COLS = heights[0].length;

        // two visited  arrays
        boolean[][] pacific = new boolean[ROWS][COLS];
        boolean[][] atlantic = new boolean[ROWS][COLS];

        // real trick is to do two seperate queues of Multisource then do a union find.
        Queue<State> pacificQ = new LinkedList<>();
        Queue<State> atlanticQ = new LinkedList<>();

        //source generation
        for(int c = 0; c < COLS ; c++) {
            pacificQ.add(new State(0, c));
            pacific[0][c] = true;

            atlanticQ.add(new State(ROWS-1, c));
           
        }

        for(int r = 0; r < ROWS;  r++) {
            pacificQ.add(new State(r, 0));
    

            atlanticQ.add(new State(r, COLS-1));
         
        }   
        bfs(pacificQ, pacific, heights);
        bfs(atlanticQ, atlantic, heights);

        //union find
        for(int r = 0; r < ROWS; r++) {
            for(int c = 0; c < COLS; c++) {
                if(atlantic[r][c] && pacific[r][c]) {
                    answer.add(new ArrayList<>(Arrays.asList(r,c)));
                }
            }
        }
        return answer;
    }
    public void bfs(Queue<State> q, boolean[][] ocean, int[][] grid) {
        while(!q.isEmpty()) {
            State state = q.poll();
            int row = state.row;
            int col = state.col;
            ocean[row][col] = true;
            for(int[] dir: directions) {
                int newRow = dir[0] + row;
                int newCol = dir[1] + col;
                if(isValid(newRow,newCol, grid, grid[row][col]) && !ocean[newRow][newCol]) {
                    q.add(new State(newRow,newCol));
                }
            }
        }

    }

    public boolean isValid(int row, int col, int[][] grid, int value) {
        return 0 <= row && row < ROWS && 0 <= col && col < COLS && grid[row][col] >= value;

    }
}
