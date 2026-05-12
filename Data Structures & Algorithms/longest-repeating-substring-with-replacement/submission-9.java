class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> freqMap = new HashMap<>();
       int answer = 0;
        int left = 0;
        int maxFreq = 0;
        for(int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            freqMap.put(c, freqMap.getOrDefault(c, 0) +1);
            maxFreq = Math.max(maxFreq, freqMap.get(c));
            while((right - left + 1) - maxFreq > k) {
                char l = s.charAt(left);
                freqMap.put(l, freqMap.get(l)-1);

                left++;
            }
            answer = Math.max(right - left +1, answer);
        }
        return answer;
        
    }
}
