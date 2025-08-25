class Solution {
    public int cherryPickup(int[][] grid) {
        int r=grid.length;
        int c=grid[0].length;
		int memo[][][]=new int[r][c][c];
		for(int i=0;i<r;i++){
			for(int j=0;j<c;j++){
				Arrays.fill(memo[i][j],-1);
			}
		}
		return get(0,0,c-1,r,c,grid,memo);
	}

	public static int get(int i,int aj,int bj,int r,int c,int[][] grid,int[][][] memo){
		if(aj<0 || bj<0 || aj>c-1 || bj>c-1) return (int)-1e9;
		if(i==r-1) {
			if(aj==bj) return grid[i][aj];
			else return grid[i][aj]+grid[i][bj];
		}
		if(memo[i][aj][bj]!=-1) return memo[i][aj][bj];
		int max=Integer.MIN_VALUE;
		for(int k=-1;k<=1;k++){
			for(int l=-1;l<=1;l++){
				if(aj==bj){
					max=Math.max(max,grid[i][aj] + get(i+1,aj+k,bj+l,r,c,grid,memo));
				}
				else{
					max=Math.max(max,grid[i][aj]+ grid[i][bj] + get(i+1,aj+k,bj+l,r,c,grid,memo));
				}
			}
		}
		return memo[i][aj][bj]= max;
	}
}