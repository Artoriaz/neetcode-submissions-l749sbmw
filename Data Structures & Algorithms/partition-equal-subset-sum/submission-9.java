class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if(sum % 2 != 0) return false;
        int n = nums.length;
        int target = sum /2;
        boolean[][] cache = new boolean[n+1][target + 1];
    // we take nothing at all , therefore we have 0.
    // need to seed/
    // bottom up requires some seeding.
        for(int i= 0; i <=n; i++) {
            cache[i][0] = true;
        }
        for(int i = 1; i <n + 1; i++) {
            //check boundary
            for(int j= 1; j <target +1; j++) {
                if(nums[i-1] <= j) {
                    // check skip or take
                    cache[i][j] = cache[i-1][j] || cache[i-1][j -nums[i-1]];
                } else {
                    //value too big we skip
                    cache[i][j] = cache[i-1][j];
                }
            }
        }
        return cache[n][target];
    }
}
