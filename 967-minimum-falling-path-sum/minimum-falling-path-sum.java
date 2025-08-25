class Solution {
    public int minFallingPathSum(int[][] mat) {
        int min=Integer.MAX_VALUE;
        int n=mat.length;
        int m=mat[0].length;
        int dp[]=new int[m];
        
        for(int k=0;k<n;k++){
            int temp[]=new int[m];
            for(int l=0;l<m;l++){
                if(k==0) temp[l]=mat[k][l];
                else{
                    int val=mat[k][l];
                    int s=Integer.MAX_VALUE,ld=Integer.MAX_VALUE,rd=Integer.MAX_VALUE;
                    s=val+dp[l];
                    if(l>0) ld=val+dp[l-1];
                    if(l<m-1) rd=val+dp[l+1];
                    temp[l]=Math.min(s,Math.min(ld,rd));
                }
            }
            dp=temp;
        }
		for(int j=0;j<m;j++){
			min=Math.min(dp[j],min);
		}
		return min;
    }
}
