class Solution {
    public int change(int amount, int[] coins) {
        return getWays(coins,amount,coins.length);
    }
    public static int getWays(int arr[],int target,int n){
        int dp[][]=new int[n][target+1];
        for(int j=0;j<=target;j++){
            if(j%arr[0]==0) dp[0][j]=1;
            else{
                dp[0][j]=0;
            }
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<=target;j++){
                int notpick=dp[i-1][j];
                int pick=0;
                if(arr[i]<=j){
                    pick+=dp[i][j-arr[i]];
                }
                dp[i][j]=notpick+pick;
            }
        }
        return dp[n-1][target];
    }
}