class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if(sum % 2 != 0) return false;
        Boolean[][] memo = new Boolean[nums.length][sum/2 +1];
        return dfs( 0, nums, 0, sum /2, memo);
    }
    public boolean dfs(int i, int[] nums, int curSum, int curTarget, Boolean[][] memo) {
            if(curSum == curTarget) return true;
        if(i == nums.length) return false;
    
        if(memo[i][curSum] != null) return memo[i][curSum];
        boolean include = false;
        if(nums[i] + curSum <= curTarget) include = dfs( i+1, nums, curSum +nums[i], curTarget, memo);
        boolean skip = dfs(i+1, nums, curSum , curTarget, memo);

        return memo[i][curSum] = include || skip;
        
    }
}
