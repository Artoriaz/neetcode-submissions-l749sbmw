class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer> freqMap = new HashMap<>();
        int left =0;
        int maxF =0;
        int answer = 0;
        for(int right = 0; right < s.length(); right++ ) {
            char c = s.charAt(right);
            
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
            maxF= Math.max(maxF, freqMap.get(c));
            while((right - left + 1 ) - maxF > k) {
                char l = s.charAt(left);
                freqMap.put(l, freqMap.get(l) -1);
                left++;
            }
            answer = Math.max(answer, right - left + 1);
        }
        return answer;
    }
}
