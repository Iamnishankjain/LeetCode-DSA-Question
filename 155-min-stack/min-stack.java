import java.util.AbstractMap;
class MinStack {

    Stack<Map.Entry<Integer,Integer>> s=new Stack<>();
    
    public void push(int val) {
        int key=val;
        if(!s.isEmpty()){
            if(key>s.peek().getValue()){
                key=s.peek().getValue();
            }
        }
        s.push(new AbstractMap.SimpleEntry<>(val, key));
    }
    
    public void pop() {
        s.pop();
    }
    
    public int top() {
        return s.peek().getKey();
    }
    
    public int getMin() {
        return s.peek().getValue();
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