class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;

        // seed row 0: patterns like a*, a*b* matching empty string
        for (int j = 2; j <= n; j++) {
            if (p.charAt(j-1) == '*') dp[0][j] = dp[0][j-2];
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j-1) == '*') {
                    boolean starCharMatches = j >= 2 &&
                        (p.charAt(j-2) == s.charAt(i-1) || p.charAt(j-2) == '.');
                    dp[i][j] = dp[i][j-2]                       // zero occurrences
                            || (starCharMatches && dp[i-1][j]); // one more
                } else {
                    boolean match = s.charAt(i-1) == p.charAt(j-1)
                                 || p.charAt(j-1) == '.';
                    dp[i][j] = match && dp[i-1][j-1];
                }
            }
        }
        return dp[m][n];
    }
}