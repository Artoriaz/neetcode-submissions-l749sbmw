class Solution {
    int n;
    int m;
    int[][] cache;
    public int numDistinct(String s, String t) {
        n = s.length();
        m = t.length();
        if(n < m) return 0;
        //counting indices , 0 is a valid
        cache = new int[n+1][m+1];
        for(int[] c: cache) {
            Arrays.fill(c, -1);
        }
        return dfs(0, 0, s, t);
    }
    public int dfs(int i , int j, String s, String t) {
        if(j == t.length()) return 1;
        if( i>= s.length()) return 0;
        if(cache[i][j] != -1) return cache[i][j];

        int total = dfs(i+1, j, s, t);
        if(s.charAt(i) == t.charAt(j)) {
            total += dfs(i+1, j+1, s , t);
        }

        return cache[i][j] = total;
    }
}
