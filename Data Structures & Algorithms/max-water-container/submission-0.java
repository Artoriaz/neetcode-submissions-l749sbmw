class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length-1;
        int answer =0;
        while(left < right ){
            int area  =  (right - left ) * Math.min(heights[left],heights[right]);
            answer = Math.max(answer, area);

            if(heights[left] < heights[right]) {
                left++;
            }  else {
                right--;
            }
        }
        return answer;
    }
}
