class Solution {
    public int climbStairs(int n) {
        int prev1=1;
        int prev=1;
        for(int i=2;i<=n;i++){
            int currI=prev1+prev;
            prev1=prev;
            prev=currI;
        }
        return prev;
    }
}