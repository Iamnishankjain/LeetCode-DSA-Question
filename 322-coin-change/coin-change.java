class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int memo[][]=new int[n][amount+1];
        for(int i=0;i<n;i++){
            Arrays.fill(memo[i],-1);
        }
        int ans= get(n-1,coins,amount,memo);
        return ans>=(int)1e9 ? -1 : ans;
    }
    public int get(int n,int coins[],int amount,int memo[][]){
        if(n==0){
            if(amount%coins[0]==0) return amount/coins[0];
            return (int)1e9;
        }
        if(memo[n][amount]!=-1) return memo[n][amount];
        int notTake=get(n-1,coins,amount,memo);
        int take=Integer.MAX_VALUE;
        if(coins[n]<=amount){
            take=1+get(n,coins,amount-coins[n],memo);
        }
        memo[n][amount]= Math.min(take,notTake);
        return memo[n][amount];
    }
}