class MinStack {

    Stack<Long> s=new Stack<>();
    long min=0;
    public void push(int val) {
        if(s.isEmpty()){
            min=val;
            s.push((long)val);
        }
        else{
            if(min<=val) s.push((long)val);
            else{
                s.push(2*(long)val-min);
                min=(long)val;
            }
        }
    }
    
    public void pop() {
        if(s.size()==0) return;
        long x=s.pop();
        if(x<min){
            min=2*min-x;
        }
    }
    
    public int top() {
        if(s.size()==0) return -1;
        long x=s.peek();
        if(min<x) return (int)x;
        else return (int)min;
    }
    
    public int getMin() {
        return (int)min;
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