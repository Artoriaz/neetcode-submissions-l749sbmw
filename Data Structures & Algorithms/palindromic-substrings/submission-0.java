class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] cache = new boolean[n][n];
        int answer =0;
        for(int i = n-1; i >= 0; i--) {
            for(int j = i ; j < n; j++) {
                if(s.charAt(i) == s.charAt(j) && (j - i<=2 || cache[i + 1][ j- 1])) {
                    cache[i][j] = true;
                    answer++;
                }
            }

            
        }
        return answer;
    }

    
}
