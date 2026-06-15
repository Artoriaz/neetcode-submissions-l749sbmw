class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] cache = new int[n];
        Arrays.fill(cache, -1);
        int maxL = 1;
        for(int i= 0; i < n; i++) {
            maxL = Math.max(maxL, dfs(i, cache, nums));
        }
        return maxL;
    }

    public int dfs(int i, int[] cache, int[] nums) {
        if(cache[i] != -1) return cache[i];

        int curLen = 1;
        for(int j= i +1 ; j < nums.length; j++) {
            if(nums[i] < nums[j]) {
                curLen = Math.max(curLen, 1+ dfs(j, cache, nums));
            }
        }
        cache[i] = curLen;
        return curLen;
    }
}
