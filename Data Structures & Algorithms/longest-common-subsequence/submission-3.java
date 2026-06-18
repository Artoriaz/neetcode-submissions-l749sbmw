class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] cache = new int[m+1][n+1];
        cache[0][0] = 0;
        // recheck boundaries
        for(int row = 1; row < m+1; row++) {
            for(int col =1 ; col < n+1; col++) {
                if(text1.charAt(row-1) == text2.charAt(col-1)) {
                    cache[row][col] = 1 + cache[row-1][col-1];
                } else {
                    cache[row][col] = Math.max(cache[row-1][col], cache[row][col-1]);
                }
            }
        }

        return cache[m][n];
    }
}
