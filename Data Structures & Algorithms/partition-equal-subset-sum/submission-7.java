class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if(sum % 2 != 0) return false;
        int n = nums.length;
        Boolean[][] cache = new Boolean[n][sum /2 + 1];
        return dfs(0, cache, nums, sum /2);
    }
    public boolean dfs(int i, Boolean[][] cache, int[] nums, int target) {
        if(i == nums.length) return target == 0;
        if(target < 0) return false;
        if(cache[i][target] != null) return cache[i][target];

        return cache[i][target] = dfs(i+1, cache, nums, target) || dfs(i+1, cache, nums, target - nums[i]);
    }
}
