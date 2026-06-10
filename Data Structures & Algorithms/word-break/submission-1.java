class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
       boolean[] cache = new boolean[n+1];
       cache[0] = true;

       for(int start = 0; start < n ; start++) {
            if(!cache[start]) continue;
            for(int end = start + 1; end <= n; end++) {
                if(wordDict.contains(s.substring(start,end))) {
                    cache[end] =true;
                }
            }
       }
       return cache[n]; 
    }
}
