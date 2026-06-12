class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int[] cache = new int[n];
        int answer = 1;
        Arrays.fill(cache, -1);
        for(int i=0; i < n; i++) {
            answer = Math.max(answer, dfs(i, cache, nums));
        }
        return answer;
    }

    public int dfs(int i , int[] cache, int[] nums) {
        if(cache[i] != -1) return cache[i];
        int longest = 1;
        for(int j = i+1; j< nums.length; j++) {
            if(nums[i] < nums[j]) {
                longest = Math.max(longest, 1+ dfs(j, cache, nums));
            }
        }

        cache[i] = longest;
        return longest;
    }
}
