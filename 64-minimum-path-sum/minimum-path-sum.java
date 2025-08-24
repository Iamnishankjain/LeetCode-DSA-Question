class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int dp[]=new int[n];
        for(int i=0;i<m;i++){
            int temp[]=new int[n];
            for(int j=0;j<n;j++){
                if(i==0 && j==0){
                    temp[j]=grid[i][j];
                }
                else{
                    int upSum=Integer.MAX_VALUE,leftSum=Integer.MAX_VALUE;
                    if(i>0) upSum=dp[j];
                    if(j>0) leftSum=temp[j-1];
                    temp[j]=grid[i][j]+Math.min(upSum,leftSum);
                }
            }
            dp=temp;
        }
        return dp[n-1];
    }
}