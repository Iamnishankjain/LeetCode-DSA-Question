class Solution {
    public String shortestCommonSupersequence(String s1, String s2) {
        int n1=s1.length();
		int n2=s2.length();
		int dp[][]=new int[n1+1][n2+1];
		for(int i=1;i<=n1;i++){
			for(int j=1;j<=n2;j++){
        		if(s1.charAt(i-1)==s2.charAt(j-1)) 
        		   dp[i][j]= 1+dp[i-1][j-1];
        		else
        		    dp[i][j]= Math.max(dp[i-1][j],dp[i][j-1]);
			}
		}
		return get(n1,n2,dp,s1,s2,"");
    }

	public static String get(int n,int m,int[][] dp,String s1,String s2,String ans){
		if(n == 0 && m == 0) return ans;

        if(n == 0){
            return get(n, m-1, dp, s1, s2, s2.charAt(m-1) + ans);
        }

        if(m == 0){
            return get(n-1, m, dp, s1, s2, s1.charAt(n-1) + ans);
        }

		if(s1.charAt(n-1)==s2.charAt(m-1)){
			return get(n-1,m-1,dp,s1,s2,s1.charAt(n-1)+ans);
		}
		else{
			if(dp[n][m]==dp[n][m-1]){
				return get(n,m-1,dp,s1,s2,s2.charAt(m-1)+ans);
			}else{
				return get(n-1,m,dp,s1,s2,s1.charAt(n-1)+ans);
			}
		}
	}
}