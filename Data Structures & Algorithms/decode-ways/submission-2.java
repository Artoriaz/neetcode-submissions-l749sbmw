class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        Integer[] cache = new Integer[n+1];

        return dfs(0, s, cache);
    }
    public int dfs(int i , String s, Integer[] cache) {
        
        if(i == s.length()) {
            return 1;
        }
        if(s.charAt(i) == '0') return 0;
        if(cache[i] != null) return cache[i];

        int ways = dfs(i+1, s, cache);
        if(i+1 < s.length() && (s.charAt(i) == '1' ||
         s.charAt(i) == '2' && s.charAt(i+1) < '7')) {
            ways += dfs(i+2, s, cache);
        }

        return cache[i] = ways;
    }
}
