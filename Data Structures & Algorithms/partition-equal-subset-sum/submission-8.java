class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if(sum % 2 != 0) return false;
        int n = nums.length;
        Boolean[][] cache = new Boolean[n][sum /2+1];

        return dfs(0, nums, cache, sum /2);

    }

    public boolean dfs(int i, int[] nums, Boolean[][] cache, int target) {
        if(i == nums.length) return target == 0;
        if(target < 0) {
            return false;
        }
        if(cache[i][target] != null) return cache[i][target];
    // no take vs take
        return cache[i][target] = dfs(i+1, nums, cache, target) || dfs(i+1, nums, cache, target-nums[i]);
    }
}
