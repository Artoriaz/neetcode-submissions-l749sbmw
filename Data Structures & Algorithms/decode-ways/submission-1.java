class Solution {
    public int numDecodings(String s) {
        int[] cache = new int[s.length() +1];
        cache[s.length()] = 1;
        for(int i = s.length() -1; i >= 0; i--) {
            if(s.charAt(i) == '0') {
                cache[i] = 0;
            } else {
                cache[i] = cache[i+1];
                if(i+1 < s.length() && (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i+1) < '7')){
                    cache[i] += cache[i +2];
                }
            }
        }
        return cache[0];
    }
}
