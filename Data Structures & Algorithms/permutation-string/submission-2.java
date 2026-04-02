class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) {
            return false;
        }

        Map<Character, Integer> count1 = new HashMap<>();
        for(char ch: s1.toCharArray()) {
            count1.put(ch, count1.getOrDefault(ch, 0) + 1);
        }

         int need = count1.size();

        for(int left = 0; left < s2.length(); left++) {
            Map<Character, Integer> count2 = new HashMap<>();
            int cur = 0;
            for(int right = left ; right < s2.length(); right++) {
                char c = s2.charAt(right);
                count2.put( c, count2.getOrDefault(c, 0) + 1);
                if(count1.getOrDefault(c, 0) < count2.get(c)) {
                    break;
                }
                if(count1.getOrDefault(c,0) == count2.get(c)) {
                    cur++;
                }
                if(cur == need) {
                    return true;
                }
            }

        }
        return false;

    }
}
