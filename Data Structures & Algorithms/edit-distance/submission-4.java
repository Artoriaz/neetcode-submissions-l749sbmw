class Solution {
    public int minDistance(String word1, String word2) {
        Integer[][] cache = new Integer[word1.length()][word2.length()];

        return dfs(0,0, word1,word2, cache);
    }
    public int dfs(int i, int j, String s1, String s2, Integer[][] cache) {
        if(i == s1.length()) return s2.length() - j;
        if(j == s2.length()) return s1.length() -i;
        if(cache[i][j] != null) return cache[i][j];

        if(s1.charAt(i) == s2.charAt(j)) {
             cache[i][j] = dfs(i+1,j+1, s1,s2,cache);
        } else {
            int del = dfs(i+1, j, s1,s2,cache);
            int ins = dfs(i, j+1, s1,s2,cache);
            int rep = dfs(i + 1, j + 1, s1,s2,cache);

             cache[i][j]= 1 + Math.min(del, Math.min(ins,rep));
        }
        return cache[i][j];
    }
}
