class Solution {
    List<List<Integer>> answer;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        answer = new ArrayList<>();
        Arrays.sort(nums);
        dfs(0, nums, target, 0, new ArrayList<>());
        return answer;
        
    }
    public void dfs(int i, int[] nums, int target, int currSum, List<Integer> subset) {
        if(currSum == target) {
            answer.add(new ArrayList<>(subset));
            return;
        }

        for(int j = i; j < nums.length; j++) {
            if(currSum  + nums[j]> target) {
                return;
            }
            subset.add(nums[j]);
            dfs(j, nums, target, currSum + nums[j], subset);
            subset.remove(subset.size() -1);
        }
    }
}
