class MinStack {

    private Stack<Pair> stack;

    // Inner class to store value and minimum of the stack as each element is inserted / popped
    static class Pair {
        int value;
        int min;

        public Pair (int value, int min) {
            this.value = value;
            this.min = min;
        }

        public int getPairValue() {
            return value;
        }   

        public int getPairMin() {
            return min;
        }
    }

    public MinStack() {
        this.stack = new Stack<>();
    }
    
    public void push(int val) {
        Pair p;
        if (stack.isEmpty()) {
            p = new Pair(val, val);
        } else {
            p = new Pair(val, Math.min(val, getMin()));
        }
        stack.push(p);
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        Pair p = stack.peek();
        return p.getPairValue();
    }
    
    public int getMin() {
        Pair p = stack.peek();
        return p.getPairMin();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */