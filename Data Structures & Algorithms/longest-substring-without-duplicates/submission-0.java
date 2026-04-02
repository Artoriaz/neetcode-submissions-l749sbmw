class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> charSet = new HashSet<>();
        int left = 0;
        int answer = 0;

        for(int right = 0; right < s.length(); right++ ) {
            while(charSet.contains(s.charAt(right))) {
                charSet.remove(s.charAt(left));
                left++;
            }
            charSet.add(s.charAt(right));
            answer = Math.max(answer,  right - left + 1);
        }
        return answer;
       
    }
}
