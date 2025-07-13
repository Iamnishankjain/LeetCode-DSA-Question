class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack=new Stack<>();
        int n=nums.length;
        int []arr=new int[n];
        for(int i=2*n-1;i>=0;i--){
           if(i>=n){
                while(!stack.isEmpty() && stack.peek()<=nums[i%n]){
                    stack.pop();
                }
                stack.push(nums[i%n]);
           }
           else{
                while(!stack.isEmpty() && stack.peek()<=nums[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    arr[i]=-1;
                }
                else{
                    arr[i]=stack.peek();
                }
                stack.push(nums[i]);
           }
        }
        return arr;
    }
}