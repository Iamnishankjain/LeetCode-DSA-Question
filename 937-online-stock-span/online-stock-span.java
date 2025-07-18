class StockSpanner {
    Stack<Integer> stack;
    ArrayList<Integer> list;
    public StockSpanner() {
        stack=new Stack<>();
        list=new ArrayList<>();
    }
    
    public int next(int val) {
        list.add(val);
        while(!stack.isEmpty() && stack.peek()!=-1 && list.get(stack.peek())<=val){
            stack.pop();
        }
        if(stack.isEmpty()) stack.push(-1);
        int ind=stack.peek();
        stack.push(list.size()-1);
        return  stack.peek()-ind;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */