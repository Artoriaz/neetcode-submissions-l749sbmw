class Solution {
    List<List<Integer>> answer;
    boolean[] seen;
    public List<List<Integer>> permute(int[] nums) {
        answer = new ArrayList<>();
        seen = new boolean[nums.length];
        dfs(nums, new ArrayList<>());
        return answer;
    }
    public void dfs(int[] nums, List<Integer> subset) {
        if(subset.size() == nums.length) {
            answer.add(new ArrayList<>(subset));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(seen[i]) continue;

            seen[i] = true;
            subset.add(nums[i]);
            dfs(nums, subset);
            subset.remove(subset.size() -1);
            seen[i] = false;
          
        
        }
    }
}
