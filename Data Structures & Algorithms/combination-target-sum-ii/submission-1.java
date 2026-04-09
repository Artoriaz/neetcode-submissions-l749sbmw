class Solution {
    List<List<Integer>> answer;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        answer = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(new ArrayList<>(), candidates, target, 0, 0);
        return answer;
    }
    public void dfs(List<Integer> subset, int[] nums, int target, int currSum, int start) {
        if (currSum == target) {
            answer.add(new ArrayList<>(subset));
            return;
        }
        if (currSum > target) return;

        for (int i = start; i < nums.length; i++) {
            // skip duplicates at the same decision level
            if (i > start && nums[i] == nums[i - 1]) continue;
             if (currSum + nums[i] > target) break;
    
            subset.add(nums[i]);
            dfs(subset, nums, target, currSum + nums[i], i + 1);
            subset.remove(subset.size() - 1);
        }
    }
}