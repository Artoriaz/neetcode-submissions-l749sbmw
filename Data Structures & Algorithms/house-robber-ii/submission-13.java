class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        return Math.max(dpBottomUp(Arrays.copyOfRange(nums,1, nums.length)),
                        dpBottomUp(Arrays.copyOfRange(nums,0, nums.length-1)));
        
    }
    private int dpBottomUp(int[] houses) {
        int n = houses.length;
        if(n == 1) return houses[0];
        if(n == 2) return Math.max(houses[0], houses[1]);
        int[] hoard = new int[n];

        hoard[0] = houses[0];
        hoard[1] = Math.max(houses[0], houses[1]);

        for(int i = 2; i < n; i++) {
            hoard[i] = Math.max(houses[i] + hoard[i-2], hoard[i-1]);
        }
        return hoard[n-1];
    }
}
