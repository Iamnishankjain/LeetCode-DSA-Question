class Solution {
    public int longestPalindromeSubseq(String s1) {
        String s2=new StringBuilder(s1).reverse().toString();
        int n1=s1.length();
		int n2=s2.length();
		int dp[]=new int[n2+1];
		for(int i=1;i<=n1;i++){
            int temp[]=new int[n2+1];
			for(int j=1;j<=n2;j++){
        		if(s1.charAt(i-1)==s2.charAt(j-1)) 
        		   temp[j]= 1+dp[j-1];
        		else
        		    temp[j]= Math.max(dp[j],temp[j-1]);
			}
            dp=temp;
		}
		return dp[n2];
    }
}