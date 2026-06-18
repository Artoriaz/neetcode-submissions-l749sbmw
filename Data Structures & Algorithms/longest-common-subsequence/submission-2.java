class Solution {
    int m, n;
    public int longestCommonSubsequence(String text1, String text2) {
        m = text1.length();
        n = text2.length();
        Integer[][] cache = new Integer[m][n];

        return dfs(0,0, text1,text2, cache);
    }
    public int dfs(int i, int j , String t1, String t2, Integer[][] cache) {
        if(i > t1.length()-1 || j > t2.length()-1) return 0;
        if(cache[i][j] != null) return cache[i][j];

        int longest = 0;
        // move diag BOTH
        if(t1.charAt(i) == t2.charAt(j)) {
            longest = 1 + dfs(i+1, j+1, t1,t2, cache);
        } else {
            //ONE OR THE OTHER 
            longest = Math.max(dfs(i+1,j, t1,t2, cache), dfs(i, j+1, t1,t2,cache));
        }
        cache[i][j] = longest;
        return longest;
      
    }
}
