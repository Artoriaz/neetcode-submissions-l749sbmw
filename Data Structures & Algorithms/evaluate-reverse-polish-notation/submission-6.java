class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(String t: tokens) {
          int a = 0;
          int b = 0;
          if(stack.size() >= 2 && t.equals("+") || t.equals("-") || t.equals("*") || t.equals("/")) {
                a = stack.pop();
                b = stack.pop();
          }
          if(t.equals("+")) {
               stack.push(a + b);
          } else if(t.equals("-")) {
               stack.push (b -a );
          } else if (t.equals("*")) {
               stack.push(a*b);
          } else if(t.equals("/")) {
               stack.push(b/a);
          } else {
               stack.push(Integer.parseInt(t));
          }
        }
        return stack.pop();
    }
}
