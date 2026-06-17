class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        Integer[][] cache = new Integer[text1.length() +1][text2.length()+1];

        return dfs(0,0, text1, text2, cache);
    }
    public int dfs(int i, int j , String t1, String t2, Integer[][] cache) {
        if(i>= t1.length() || j >= t2.length()) return 0;
        if(cache[i][j] != null) return cache[i][j];
        int longest =0;
        if(t1.charAt(i) == t2.charAt(j)) {
            longest = 1 + dfs(i+1, j+1, t1,t2, cache);
        } else {
            longest = Math.max(dfs(i+1, j, t1,t2,cache), dfs(i, j+1, t1,t2, cache));
        }  
        cache[i][j] = longest;
        return longest;
    }
}
