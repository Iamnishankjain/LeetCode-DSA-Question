class Solution {
    public int largestRectangleArea(int[] arr) {
        Stack<Integer> stack=new Stack<>();
        int maxArea=0;
        for(int i=0;i<arr.length;i++){
            while(!stack.isEmpty() && arr[stack.peek()]>arr[i]){
                int ele=arr[stack.peek()];
                stack.pop();
                int nse=i;
                int pse=stack.isEmpty() ? -1 : stack.peek();
                maxArea=Math.max(maxArea,ele*(nse-pse-1));
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int ele=arr[stack.peek()];
            stack.pop();
            int nse=arr.length;
            int pse=stack.isEmpty() ? -1 : stack.peek();
            maxArea=Math.max(maxArea,ele*(nse-pse-1));
        }
        return maxArea;
    }
}