class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        if(sum % 2 != 0) return false;
        int half = sum /2;
        Set<Integer> dp = new HashSet<>();
        dp.add(0);
        for(int i= n-1; i>= 0; i--) {
            Set<Integer> dp2 = new HashSet<>();
            for(int num: dp) {
                if(num + nums[i] == half) return true;

                dp2.add(nums[i] + num);
                dp2.add(num);

            }
            dp = dp2;
        }
        return false;
    }
}
