class Solution {
    public boolean canJump(int[] nums) {
        int maxInd=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(i>maxInd) return false;
            maxInd=Math.max(maxInd,i+nums[i]);
        }
        return true;
    }
}