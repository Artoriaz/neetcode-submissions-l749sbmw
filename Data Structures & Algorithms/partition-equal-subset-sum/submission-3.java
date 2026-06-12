class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if(sum % 2 != 0) return false;

        Set<Integer> dp = new HashSet<>();
        dp.add(0);
        int target = sum /2;
        for(int i=nums.length-1; i >= 0; i--) {
            Set<Integer> nextDp  = new HashSet<>();
            for(int n: dp) {
                if( n + nums[i] == target) return true;

                nextDp.add(nums[i] + n);
                nextDp.add(n);
            }
            dp = nextDp;
        }
        return false;
    }
}