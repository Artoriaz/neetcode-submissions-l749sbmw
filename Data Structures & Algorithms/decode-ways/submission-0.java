class Solution {
    int[] cache;
    public int numDecodings(String s) {
        int n = s.length();
        cache = new int[n];
        Arrays.fill(cache, -1);
        return decode(0, n, s);
    }
    public int decode(int i, int n, String s) {
        if(i == n) return 1;
        if(cache[i] != -1) return cache[i];
        int ways = 0;
        if(s.charAt(i) !='0') {
            ways += decode(i+1, n, s);
        }
        if(i + 1 < n) {
            int twoDigit = Integer.parseInt(s.substring(i, i+2));
            if(10 <= twoDigit && twoDigit <= 26) {
            ways += decode(i+2, n , s);
        }
        }
        return cache[i] = ways;
    }
}
