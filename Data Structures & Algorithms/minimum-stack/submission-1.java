class MinStack {
    Stack<Integer> minStack; 
    Stack<Integer> stack;
    public MinStack() {
        minStack = new Stack<>();
        stack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(!minStack.isEmpty() && minStack.peek() < val){
            minStack.push(minStack.peek());
        } else {
            minStack.push(val);
        }
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
