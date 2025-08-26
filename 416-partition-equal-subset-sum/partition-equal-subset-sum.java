class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum%2!=0) return false;
        return isSubsetSum(nums,sum/2);
    }
    public Boolean isSubsetSum(int arr[], int k) {
        // code here
        int n=arr.length;
        boolean dp[]=new boolean[k+1];
        Arrays.fill(dp,false);
        dp[0]=true;
        if(arr[0]<=k) dp[arr[0]]=true;
        
        for(int i=1;i<n;i++){
            boolean temp[]=new boolean[k+1];
            for(int j=1;j<=k;j++){
                boolean nottake=dp[j];
                boolean take=false;
                if(j>=arr[i]){
                    take= dp[j-arr[i]];
                }
                temp[j]=take || nottake;
            }
            dp=temp;
        }
        
        return dp[k];
    }
}