class Solution {
    public int cherryPickup(int[][] grid) {
        int r=grid.length;
        int c=grid[0].length;
		int dp[][]=new int[c][c];
		for(int j1=0;j1<c;j1++){
            for(int j2=0;j2<c;j2++){
                if(j1==j2){
                    dp[j1][j2]=grid[r-1][j1];
                }else{
                    dp[j1][j2]=grid[r-1][j1]+grid[r-1][j2];
                }
            }
        }

        for(int i=r-2;i>=0;i--){
            int temp[][]=new int[c][c];
            for(int j1=0;j1<c;j1++){
                for(int j2=0;j2<c;j2++){
                    int max=Integer.MIN_VALUE;
                    for(int k=-1;k<=1;k++){
                        for(int l=-1;l<=1;l++){
                            int val=grid[i][j1];
                            if(j1!=j2){
                                val+=grid[i][j2];
                            }
                            if(j1+k>=0 && j1+k<c && j2+l>=0 && j2+l<c)
                                val+=dp[j1+k][j2+l];
                            else{
                                val-=1e8;
                            }
                            max=Math.max(max,val);
                        }
                    }
                    temp[j1][j2]= max;
                }
            }
            dp=temp;
        }
		return dp[0][c-1];
	}
}