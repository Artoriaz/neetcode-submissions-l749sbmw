class Solution {
    public int minDistance(String word1, String word2) {
        Integer[][] cache = new Integer[word1.length()][word2.length()];

        return dfs(0,0, word1,word2,cache);
    }
    public int dfs(int i , int j , String s1, String s2, Integer[][] cache) {
        if( i == s1.length()) return s2.length() -j;
        if( j == s2.length()) return s1.length() -i;
        if(cache[i][j] != null) return cache[i][j];

        if(s1.charAt(i) == s2.charAt(j)) {
            cache[i][j] = dfs( i+1, j+1, s1,s2,cache);
        } else {
            int res = Math.min(dfs(i+1, j, s1, s2, cache), dfs(i , j+1, s1,s2,cache));
            res = Math.min(res, dfs( i+1, j+1, s1,s2,cache));
            cache[i][j] = res +1;
        }
        
        return cache[i][j];
    }
}
