class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);
       int[] cache = new int[n];
       int[] cache2 = new int[n];

       return Math.max(robCycles(cache, Arrays.copyOfRange(nums, 0, n-1)), robCycles(cache2, Arrays.copyOfRange(nums, 1, n)));
      
    }
    public int robCycles(int[] cache, int[] houses) {
       cache[0] = houses[0];
       cache[1] = Math.max(houses[0], houses[1]);
       for(int i = 2; i < houses.length;i++) {
        cache[i] =  Math.max(cache[i-1], cache[i-2] + houses[i]);
       }
       return cache[houses.length-1];
    }
}
