class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i< tokens.length; i++) {
               if(tokens[i].equals("+") || tokens[i].equals("/") || tokens[i].equals("*") || tokens[i].equals("-") ) {
                    int firstOp = stack.pop();
                    int secondOp = stack.pop();

                   if(tokens[i].equals("+")) {
                        stack.push(firstOp +  secondOp);
                   } else if(tokens[i].equals("*")) {
                        stack.push(firstOp * secondOp);
                   } else if(tokens[i].equals("/")) {
                        stack.push(secondOp / firstOp);
                   } else if(tokens[i].equals("-")) {
                        stack.push(secondOp - firstOp);
                   } 
               } else {
                stack.push(Integer.parseInt(tokens[i]));
               }         
            
        }
        return stack.pop();
    }
}
