class Solution {
    public int maximalRectangle(char[][] matrix) {
        int maxArea=0;
        int n=matrix.length,m=matrix[0].length;
        int preSum[][]=new int[n][m];
        for(int j=0;j<m;j++){
            int sum=0;
            for(int i=0;i<n;i++){
                sum+=1;
                if(matrix[i][j]=='0') sum=0;
                preSum[i][j]=sum;
            }
        }
        for(int i=0;i<n;i++){
            maxArea=Math.max(maxArea,largestRectangleArea(preSum[i]));
        }
        return maxArea;
    }
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