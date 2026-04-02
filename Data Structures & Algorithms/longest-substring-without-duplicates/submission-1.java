class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> charSet = new HashSet<>();
        int answer = 0;
        int left = 0;
        char[] charS = s.toCharArray();
        for(int right = 0; right < charS.length; right++) {
            // cleaning
            while(charSet.contains(charS[right])) {
                //move leftbound and erase from set
                charSet.remove(charS[left]);
                left++;
            }

            charSet.add(charS[right]);
            //add 1 bc 0 index
            answer = Math.max(answer, right - left + 1);
        }
        return answer;
    }
}
