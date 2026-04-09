class Solution {
    List<List<Integer>> answer;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        answer = new ArrayList<>();
        Arrays.sort(nums);
        dfs(0, nums, new ArrayList<>());
        return answer;

    }

    public void dfs(int i, int[] nums, List<Integer> subset) {
        if(i == nums.length) {
            answer.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[i]);
        dfs(i + 1, nums, subset);
        subset.remove(subset.size() -1);

        // do clean up here
        while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
            i++;
        }
        dfs(i +1, nums,subset);

    }
}