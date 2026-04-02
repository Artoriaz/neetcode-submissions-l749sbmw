class Solution {
    public int maxProfit(int[] prices) {
        int left = 0;
        int answer = 0;

        for(int right = 1; right < prices.length; right++) {
            if(prices[left] < prices[right]) {
                answer = Math.max(answer, prices[right] - prices[left]);
            } else {
                left = right;
            }
        }
        

        return answer;
    }
}
