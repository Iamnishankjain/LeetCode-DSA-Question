class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack=new Stack<>();
        int n=nums.length;
        int []arr=new int[n];
        for(int i=2*n-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek()<=nums[i%n]){
                stack.pop();
            }
            if(stack.isEmpty()){
                arr[i%n]=-1;
            }
            else{
                arr[i%n]=stack.peek();
            }
            stack.push(nums[i%n]);
        }
        return arr;
    }
}