class Solution {
    int[] moneyHoard;
    public int rob(int[] nums) {
         moneyHoard = new int[nums.length];
        Arrays.fill(moneyHoard, -1);
        return dfs(nums,0);
    }
    public int dfs(int[] houses, int i) {
        if(i >= houses.length) return 0;
        if(moneyHoard[i] != -1) return moneyHoard[i];
        // Math.max decision to go with this house or the next house
        moneyHoard[i] = Math.max(houses[i] + dfs(houses, i+2), dfs(houses, i+1));
        return moneyHoard[i];
    }
}
