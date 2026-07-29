class Solution {
    public boolean isMatch(String s, String p) {
        // recheck boundaries
        Boolean[][] cache = new Boolean[s.length()+1][p.length()+1];

        return dfs(0,0, cache, s, p);
    }
    public boolean dfs(int i, int j, Boolean[][] cache, String s1, String s2) {
        if(j == s2.length()) return i == s1.length();
        if(cache[i][j] != null) return cache[i][j];
        boolean currMatch = i < s1.length() && 
        (s1.charAt(i) == s2.charAt(j) || s2.charAt(j) == '.');
        boolean ans;
        // we can skip OR keep matching
        if(j+ 1< s2.length() && s2.charAt(j+1) == '*') {
            //skip the *
            ans = dfs(i, j+2,cache,s1,s2) ||
            (currMatch && dfs(i+1, j, cache,s1,s2));
        } else {
           ans = currMatch && dfs(i+1,j+1, cache, s1,s2);
        }


        return cache[i][j] = ans;
    }
}
