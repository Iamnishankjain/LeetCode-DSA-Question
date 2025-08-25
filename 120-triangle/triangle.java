class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int dp[]=new int[n];
        for(int i=n-1;i>=0;i--){
            int temp[]=new int[n];
            for(int j=i;j>=0;j--){
                if(i==n-1) temp[j]=triangle.get(i).get(j);
                else{
                    int d=triangle.get(i).get(j)+dp[j];
                    int dg=triangle.get(i).get(j)+dp[j+1];
                    temp[j]=Math.min(d,dg);
                }
            }
            dp=temp;
        }
        return dp[0];
    }
}