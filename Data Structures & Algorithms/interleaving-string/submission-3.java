class Solution {
    Boolean[][] cache;
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false;
        //if(s1.isEmpty() && s2.isEmpty() && s3.isEmpty()) return true;
        int x = s3.length();
        cache = new Boolean[s1.length() + 1][s2.length()+1];
       return dfs(0,0, s1,s2,s3);
    }

    public boolean dfs(int i , int j, String s1, String s2, String s3) {
        if(i == s1.length() && j == s2.length()) return true;
        if(cache[i][j] != null) return cache[i][j];

        boolean left = false, right = false;
        if(i < s1.length() && s1.charAt(i) == s3.charAt(i+j)) {
            left = dfs(i +1, j , s1,s2,s3);
        }
        if(j < s2.length() && s2.charAt(j) == s3.charAt(i+j)) {
            right = dfs(i, j+1, s1,s2,s3);
        }
        return cache[i][j] = left || right;
    }
}
