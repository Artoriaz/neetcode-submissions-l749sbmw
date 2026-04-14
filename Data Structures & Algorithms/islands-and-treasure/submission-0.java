class Solution {
    class State {
        int row;
        int col; 
        int distance;
        public State(int row, int col, int distance) {
            this.row = row;
            this.distance = distance;
            this.col = col;
        }
    }
    int rowLength;
    int colLength;
    boolean[][] visited;
    int[][] directions = {{0,1}, {0, -1} , {1,0}, {-1,0}};
    public void islandsAndTreasure(int[][] grid) {
        rowLength = grid.length;
        colLength = grid[0].length;
        visited = new boolean[rowLength][colLength];
        Queue<State> queue = new LinkedList<>();
        for(int row =0 ; row < rowLength; row++) {
            for(int col = 0 ; col < colLength; col++) {
                if(grid[row][col] == 0 && !visited[row][col]) {
                    visited[row][col] = true;
                    queue.add(new State(row, col, 0));
                }
            }
        }

        while(!queue.isEmpty()) {
            State node = queue.poll();

            for(int[] dir: directions) {
                int newRow = node.row + dir[0];
                int newCol = node.col + dir[1];
                if(isValid(newRow, newCol, grid) && !visited[newRow][newCol]) {
                    visited[newRow][newCol] = true;
                    queue.add(new State(newRow, newCol, node.distance +1));
                    grid[newRow][newCol] = node.distance +1;
                }
            }
        }
        return;

    }
    public boolean isValid(int row, int col, int[][] grid) {
        return 0 <= row && row < rowLength && 0 <= col && col < colLength && grid[row][col] == Integer.MAX_VALUE;
    }
 
}
