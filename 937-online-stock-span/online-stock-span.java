class StockSpanner {
    Stack<int[]> stack=new Stack<>();
    int ind;
    public StockSpanner() {
       stack.clear();
        ind=-1;
    }
    
    public int next(int val) {
        ind++;
        while(!stack.isEmpty() && stack.peek()[0]<=val){
            stack.pop();
        }
        int ans=ind-(stack.isEmpty() ? -1 : stack.peek()[1]);
        stack.push(new int[]{val,ind});
        return  ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */