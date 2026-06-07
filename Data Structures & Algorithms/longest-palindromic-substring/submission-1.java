class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] cache = new boolean[n][n];

        int index = 0, length = 0;

        for(int i = n-1; i >= 0; i--) {
            for(int j = i; j < n; j++) {
                if(s.charAt(i) == s.charAt(j) && (j - i <= 2 || cache[i+1][j-1])) {
                    cache[i][j] = true;
                    if(length < j - i + 1 ) {
                        index = i;
                        length = j - i + 1;
                    }
                }
            }
        }
        return s.substring(index, index + length);
    }
}
