class Solution {
    public int longestConsecutive(int[] nums) {
      Set<Integer> hashSet = new HashSet<>();

        for(int num: nums) {
            hashSet.add(num);
        }
        int longest = 0;

        for(int num: hashSet) {
            if(!hashSet.contains(num-1)) {
                int length =1;
                while(hashSet.contains(num + length)) {
                    length++;
                }
                longest = Math.max(longest,length);
            }
        }
        return longest;
    }
}
