class Solution {
     Set<Integer> cols = new HashSet<>();       // columns used
     Set<Integer> diag = new HashSet<>();       // row - col values used
     Set<Integer> antiDiag = new HashSet<>();
     List<List<String>> totalSolutions;  
    public List<List<String>> solveNQueens(int n) {
        String[][] board = new String[n][n];
        totalSolutions = new ArrayList<>();
        List<String> solution = new ArrayList<>();
        dfs(0, solution, n);

        return totalSolutions;
    }
    public void dfs(int row, List<String> solution, int n) {
        if(row == n) {
            totalSolutions.add(new ArrayList<>(solution));
            return;
        }

        for(int col = 0; col < n; col++) {
            if(isValid(row, col)) {
                char[] rows = new char[n];
                Arrays.fill(rows, '.');
                rows[col] = 'Q';

                cols.add(col);
                diag.add(row - col);
                antiDiag.add(row + col);


                solution.add(new String(rows));

                dfs(row + 1, solution, n);
                solution.remove(solution.size() - 1);
                cols.remove(col);
                diag.remove(row - col);
                antiDiag.remove(row + col);
            }
        }


    }
    public boolean isValid(int row, int col) {
        return !cols.contains(col) && !diag.contains(row - col) && !antiDiag.contains(row + col);
    }

}
