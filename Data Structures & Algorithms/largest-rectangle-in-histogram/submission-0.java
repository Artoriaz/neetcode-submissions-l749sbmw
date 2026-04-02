class Solution {
    public int largestRectangleArea(int[] heights) {
        int answer = 0;
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i<= n; i++) {
            while(!stack.isEmpty() &&
           ( i == n || heights[stack.peek()] >= heights[i])) {
                int h = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() -1;
                answer = Math.max(answer, h * width);
  
            }
            stack.push(i);
        }
        return answer;
}
}