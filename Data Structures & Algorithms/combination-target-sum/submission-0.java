class Solution {
    int goal;
    List<List<Integer>> answer;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        goal = target;
        List<Integer> subset = new ArrayList<>();
        answer = new ArrayList<>();
        dfs(subset, nums, 0 , 0);
        return answer;
    }
    public void dfs(List<Integer> subset, int[] nums, int i, int currSum) {
        if(currSum  > goal ||  i >= nums.length) {
            return;
        }
        if(currSum == goal) {
            answer.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[i]);
        dfs(subset, nums, i, currSum + nums[i]);

        subset.remove(subset.size() -1);
        dfs(subset, nums, i + 1, currSum);
    }
}
