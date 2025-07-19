class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int leftSum=0,maxSum=0;
        int n=cardPoints.length;

        for(int i=0;i<k;i++) leftSum+=cardPoints[i];
        maxSum=leftSum;
        int r=n-1;
        for(int i=k-1;i>=0;i--){
            leftSum-=cardPoints[i];
            leftSum+=cardPoints[r];
            r--;
            maxSum=Math.max(maxSum,leftSum);
        }
        return maxSum;
    }
}