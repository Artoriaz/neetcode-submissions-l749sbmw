class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length()+1;
        int m = word2.length()+1;
        int[][] cache = new int[n][m];
        cache[0][0] = 0;
        //seeding for del
        for(int i= 1; i < n; i++) {
            cache[i][0] = i;
        }
        //seeding for ins
        for(int i =1; i < m;i++) {
            cache[0][i] = i;
        }
        for(int i = 1; i < n; i++) {
            for(int j = 1; j < m; j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    cache[i][j] = cache[i-1][j-1];
                } else {
                    int ins = cache[i][j-1];
                    int del = cache[i-1][j];
                    int rep =  cache[i-1][j-1];
                    cache[i][j] = 1 + Math.min(ins, Math.min(del, rep));
                }
            }
        }
        return cache[n-1][m-1];
    }
}
