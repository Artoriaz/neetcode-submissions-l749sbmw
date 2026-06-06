class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int resIdx = 0, resLen = 0;
        boolean[][] cache = new boolean[n][n];

        for(int i = n -1 ; i >= 0; i--) {
            for(int j = i ; j < n ; j++) {
                if(s.charAt(i) == s.charAt(j) && (j - i <= 2 || cache[i+1][j-1])) {
                    cache[i][j] = true;
                    if(resLen < (j - i +1)) {
                        resIdx = i;
                        resLen = j - i + 1;
                    }
                }
            }
        }
        return s.substring(resIdx, resIdx + resLen);
    }
    
}
