class Solution {
    int[] cache;
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        cache = new int[n];
        Arrays.fill(cache,-1);
        int firstPass = dfs(0, Arrays.copyOfRange(nums, 0, n-1));
        Arrays.fill(cache,-1);
        int secondPass = dfs(0, Arrays.copyOfRange(nums, 1, n));
        return Math.max(firstPass, secondPass);
    }
    public int dfs(int i, int[] nums) {
        if(i >= nums.length) return 0;
        if(cache[i] != -1) return cache[i];
        cache[i] = Math.max(dfs(i+1, nums) , dfs(i +2, nums) + nums[i]);
        return cache[i];
    }
}
