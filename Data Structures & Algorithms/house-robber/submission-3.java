class Solution {
    public int rob(int[] nums) {
        
        int n = nums.length;
        if(n == 1) return nums[0];
        int[] cache = new int[n];
        
        cache[0]= nums[0];
        cache[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < n; i++) {
            cache[i] = Math.max(cache[i-1], cache[i-2] + nums[i]);
        }
        return cache[n-1];
    }
}
