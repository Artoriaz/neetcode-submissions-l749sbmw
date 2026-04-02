class Solution {
    public int jump(int[] nums) {
        int window = 0;
        int furthest = 0;
        int steps = 0;

        for(int i= 0; i< nums.length-1; i++ ) {
            furthest = Math.max(furthest, nums[i] + i);
            if(i == window){
                steps++;
                window = furthest;
            }
        }
        return steps;
    }
}
