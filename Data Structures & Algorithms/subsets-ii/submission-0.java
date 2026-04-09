class Solution {
    List<List<Integer>> answer;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        answer = new ArrayList<>();
        Arrays.sort(nums);
        dfs(0, nums, new ArrayList<>());
        return answer;
    }

    public void dfs(int start, int[] nums, List<Integer> subset) {
              answer.add(new ArrayList<>(subset));
       
        for(int i = start; i < nums.length; i++) {
            if(i > start && nums[i] == nums[i-1]) continue;
            subset.add(nums[i]);
            dfs(i + 1, nums, subset);
            subset.remove(subset.size() -1);

        }

    }
}