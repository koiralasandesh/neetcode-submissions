class MinStack {

    Deque<Integer> valStack;
    Deque<Integer> minStack;

    public MinStack() {
        valStack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        valStack.push(val);
        if (minStack.isEmpty()){
            minStack.push(val);
        }else{
            minStack.push(Math.min(minStack.peek(),val));
        }
        
    }
    
    public void pop() {
        minStack.pop();
        valStack.pop();
    }
    
    public int top() {
       return valStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
