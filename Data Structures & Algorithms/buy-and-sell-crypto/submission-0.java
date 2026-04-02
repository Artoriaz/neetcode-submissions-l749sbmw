class Solution {
    public int maxProfit(int[] prices) {
        int left = 0;
        int right = 1;
        int answer = 0;
        while(right < prices.length) {
            if(prices[left] < prices[right]) {
                answer = Math.max(answer, prices[right] - prices[left]);
            } else {
               left = right;
            }
            right++;
        }

        return answer;
    }
}
