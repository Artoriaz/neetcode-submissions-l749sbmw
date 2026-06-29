class Solution {
    class State { 
        int row;
        int col;
        public State (int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    int n;
    int m;
    int[][] directions = {{ 0,1}, {0,-1}, {1, 0}, {-1,0} };
    public int longestIncreasingPath(int[][] matrix) {
         n = matrix.length;
         m = matrix[0].length;

        int[][] indegree = new int[n][m];
        for(int i =0; i < n; i++ ){
            for(int j = 0; j < m; j++ ) {
                for(int[] dir: directions) {
                    int row = i + dir[0];
                    int col = j + dir[1];
                    if(isValid(row, col) && matrix[i][j] > matrix[row][col]) {
                        indegree[i][j]++;
                    }
                }
            }
        }
        Queue<State> q = new LinkedList<>();

        for(int i = 0; i <n ; i++) {
            for(int j = 0; j <m; j++) {
                if(indegree[i][j] == 0) q.offer(new State(i, j));
            }
        }
        int answer = 0;
        while(!q.isEmpty()) {
            int qSize = q.size();
            answer++;
            for(int i = 0; i < qSize; i++) {
                State cell = q.poll();
                for(int[] dir: directions) {
                    int row = cell.row + dir[0];
                    int col = cell.col + dir[1];
                    if(isValid(row, col) && matrix[row][col] > matrix[cell.row][cell.col]) {
                        indegree[row][col]--;
                        if(indegree[row][col] == 0) {
                            q.offer(new State(row, col));
                        }
                    }
                }
            }
            
        }
        return answer;
    }

    public boolean isValid(int row, int col) {
        return  0 <= row && row < n && 0<= col && col < m;
    }
}
