class Solution {
    int rowLength;
    int colLength;
    int wLength;
    char[] cWord;
    boolean answer = false;
    boolean[][] seen;
    //either need a seen or undo.
    int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    public boolean exist(char[][] board, String word) {
        colLength = board[0].length;
        rowLength = board.length;
        seen = new boolean[rowLength][colLength];
        cWord = word.toCharArray();
        wLength = word.length();

        for(int i = 0; i < rowLength; i++) {
            for(int j = 0; j < colLength; j++) {
                if(!seen[i][j] && board[i][j] == cWord[0]) {
                    seen[i][j] = true;
                    dfs(board, 1, i, j);
                    seen[i][j] = false;
                }
            }
        }
        return answer;
        
    }
    public boolean isValid(int row, int col) {
        return 0 <= row && row < rowLength && 0 <= col && col < colLength;
    }
    public void dfs (char[][] board, int letterIndice, int row, int col) {
        if(letterIndice == wLength) {
            answer = true;
            return;
        } 

        for(int[] dir: directions) {
        int newRow = row + dir[0];
        int newCol = col + dir[1];
            if(isValid(newRow, newCol) && !seen[newRow][newCol]) {
                if(board[newRow][newCol] == cWord[letterIndice]) {
                    seen[newRow][newCol] = true;
                    dfs(board, letterIndice + 1, newRow, newCol);
                    seen[newRow][newCol] = false;
                }
            }
            
        }
    }
}
