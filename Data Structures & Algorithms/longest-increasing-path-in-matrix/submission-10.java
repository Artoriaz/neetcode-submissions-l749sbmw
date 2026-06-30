class Solution {
    class State {
        int row; 
        int col;
        public State(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    int ROWS;
    int COLS;
    public int longestIncreasingPath(int[][] matrix) {
         ROWS = matrix.length;
         COLS = matrix[0].length;
        int[][] indegree = new int[ROWS][COLS];
        // set up indegree
        for(int i = 0; i <ROWS ; i++ ){ 
            for (int j = 0; j < COLS; j++) {
                for(int[] dir: directions) {
                    int nR = i + dir[0];
                    int nC = j + dir[1];
                    if(isValid(nR, nC) && matrix[i][j] < matrix[nR][nC]) {
                        indegree[nR][nC]++;
                    }
                }
            }
        }
        Queue<State> q = new LinkedList<>();

        for(int i= 0; i < ROWS; i++) {
            for(int j = 0 ; j < COLS; j++) {
                if(indegree[i][j] == 0) {
                    q.offer(new State(i,j));
                }
            }
        }
        int wave = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size ; i++) {
                State cell = q.poll();
                for(int[] dir: directions) {
                    int newRow = cell.row + dir[0];
                    int newCol = cell.col + dir[1];
                    if(isValid(newRow,newCol) && matrix[cell.row][cell.col] < matrix[newRow][newCol]) {
                        indegree[newRow][newCol]--;
                        if(indegree[newRow][newCol] == 0) {
                            q.offer(new State(newRow, newCol));
                        }
                    }
                }
            }
            wave++;
        }
        return wave;
    }
    public boolean isValid(int row, int col) {
        return 0<= row && row < ROWS && 0<= col && col < COLS;
    }
}
