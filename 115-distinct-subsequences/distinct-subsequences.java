class Solution {
    public int numDistinct(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();
        int dp[]=new int[m+1];
        dp[0]=1;
        for(int i=1;i<=n;i++){
            int temp[]=new int[m+1];
            temp[0]=1;
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    temp[j]=dp[j-1]+dp[j];
                }
                else{
                    temp[j]=dp[j];
                }
            }
            dp=temp;
        }
        return dp[m];
    }
}