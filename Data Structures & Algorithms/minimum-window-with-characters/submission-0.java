class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();
        if (t.length() == 0 || s.length() < t.length()) return "";

        for(char c: t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }
        int n = s.length();
        int left = 0;
        char[] sArr = s.toCharArray();
        int formed = 0;
        int bestL = 0;
        int bestLen = Integer.MAX_VALUE;
         int required = tMap.size();
        for(int right = 0; right < n; right++) {
            char c=  sArr[right];
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);

            if (tMap.containsKey(c) && sMap.get(c)== tMap.get(c)) {
                formed++;
            }

            while(left <= right && formed == required) {
               int windowLength = right - left + 1;
               //looking for smallest
               if(windowLength < bestLen) {
                bestLen = windowLength;
                bestL = left;
               }
               char d = sArr[left];
               sMap.put(d, sMap.get(d) - 1);   
               if(tMap.containsKey(d) && sMap.get(d) < tMap.get(d)) {
                formed--;
               }
               left++;
            }
            
        }
        
        return bestLen == Integer.MAX_VALUE ? "" : s.substring(bestL, bestL + bestLen);
    }
}
