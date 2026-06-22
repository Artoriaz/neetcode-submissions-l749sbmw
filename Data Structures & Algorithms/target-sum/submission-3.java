class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int ceiling = Arrays.stream(nums).sum();
        if(Math.abs(target) > ceiling) return 0;
        int[][] cache = new int[nums.length + 1][ceiling *2 +1];

         cache[0][ceiling] = 1;
        for(int i=1; i <= nums.length; i++) {
            for(int j = 0; j <= ceiling*2; j++) {
                int ways = 0;
                if(j - nums[i-1] >= 0)
                    ways += cache[i-1][j - nums[i-1]];
                if(j + nums[i-1] <= ceiling*2)
                    ways += cache[i-1][j + nums[i-1]];
                cache[i][j] = ways;
                }
        }
        return cache[nums.length][target + ceiling];
    }
}
