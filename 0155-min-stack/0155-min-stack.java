class MinStack {
    List<Integer> list = new ArrayList<>();
    int top = -1;
    int min = Integer.MAX_VALUE;

    public MinStack() {
        
    }
    
    public void push(int val) {
        min = Math.min(val, min);
        list.add(val);
        top++;
    }
    
    public void pop() {
        if(list.get(top)==min) {    
            list.remove(top);
            top--;
            pushMin();
        }
       else{
        list.remove(top);
        top--;
        }
    }
    
    public int top() {
        return list.get(top);
    }
    
    public int getMin() {
        return min;
    }
    public void pushMin() {
        min=Integer.MAX_VALUE;
            for(int i=0; i<=top; i++) {
                min = Math.min(list.get(i), min);
            }
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