class Solution {
    public int jump(int[] nums) {
        int window = 0;
        int jumps = 0;
        int furthest =0;

        for(int i = 0 ; i < nums.length-1; i++) {
            furthest = Math.max(furthest, i + nums[i]);
            if( i == window) {
                jumps++;
                window = furthest;
            }
        }
        return jumps;
    }
}
