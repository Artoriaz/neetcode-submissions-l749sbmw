class Solution {
    int[] cache;
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        cache = new int[n];
        cache[0] = cost[0];
        cache[1] = cost[1];
        for(int i =2 ; i<n; i++) {
            cache[i] = cost[i] + Math.min(cache[i-2], cache[i-1]);
        }
        return Math.min(cache[n-1], cache[n-2]);
    }
}
