class Solution {
    int n;
    int m;
    int[][] cache;
    public int numDistinct(String s, String t) {
        n = s.length();
        m = t.length();
        //counting indices , 0 is a valid
        cache = new int[n+1][m+1];
        for(int[] c: cache) {
            Arrays.fill(c, -1);
        }
        return dfs(0, 0, 0, s, t);
    }
    public int dfs(int i , int j , int stringSize, String s, String t) {
        if(stringSize == t.length()) return 1;
        if( i>= s.length() || j >= t.length()) return 0;
        if(cache[i][j] != -1) return cache[i][j];

        int left = 0;
        if(s.charAt(i) == t.charAt(j)) {
            left += dfs(i+1, j+1,stringSize+1, s , t);
        }

        return cache[i][j] = left + dfs(i+1, j, stringSize, s, t);
    }
}
