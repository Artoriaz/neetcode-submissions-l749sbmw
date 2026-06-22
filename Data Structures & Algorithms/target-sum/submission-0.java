class Solution {
    int ceiling;
    public int findTargetSumWays(int[] nums, int target) {
        ceiling = Arrays.stream(nums).sum();
        Integer[][] cache = new Integer[nums.length+1][(ceiling *2) + 1];

        return dfs(0, 0, cache, nums, target);
    }
    public int dfs(int i, int current,  Integer[][] cache, int[] nums, int target) {
        if(i >=  nums.length) return current == target ? 1 : 0;
        if(cache[i][current + ceiling] != null) return cache[i][current + ceiling];

        return cache[i][current + ceiling] = dfs(i+1, current + nums[i], cache, nums, target) + dfs(i+1, current - nums[i], cache, nums, target);
    }
}
