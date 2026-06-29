class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false;
        int n = s1.length();
        int m = s2.length(); 
        Boolean[][] cache = new Boolean[n+1][m+1];
        return dfs(0, 0, s1,s2,s3, cache);
    }
    public boolean dfs(int i, int j , String s1, String s2, String s3, Boolean[][] cache) {
        if(i + j == s3.length()) return true;
        if(cache[i][j] != null) return cache[i][j];

        boolean left = false;
        boolean right = false;
        if(i < s1.length() && s1.charAt(i) == s3.charAt(i+j)) {
            left = dfs(i+1, j ,s1,s2,s3, cache);
        }
        if(j <s2.length() && s2.charAt(j) == s3.charAt(i+j)) {
            right = dfs(i, j+1, s1,s2,s3, cache);
        }

        return cache[i][j] = left || right;
    }

}
