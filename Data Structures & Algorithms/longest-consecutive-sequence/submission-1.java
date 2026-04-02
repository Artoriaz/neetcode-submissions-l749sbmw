class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();
        //adding to hashSet
        for(int num: nums) {
            hashSet.add(num);
        }
        int answer = 0;

        // loop, check if there is a no left bound to start sequence
        // add to the count
        for(int num: nums) {
            int length = 1;
            if(!hashSet.contains(num -1) ) {
                while(hashSet.contains(num + length) ) {
                    length++;
                }
            }
            answer= Math.max(answer, length);
        }
            return answer;
    }

}
