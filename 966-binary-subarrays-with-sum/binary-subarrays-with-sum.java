class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return numSubarrayslessSum(nums,goal)-numSubarrayslessSum(nums,goal-1);
    }
    public int numSubarrayslessSum(int[] nums, int goal) {
        if(goal<0) return 0;
        int cnt=0,sum=0;
        int l=0;
        for(int r=0;r<nums.length;r++){
            sum+=nums[r];
            while(sum>goal){
                sum-=nums[l];
                l++;
            }
            if(sum<=goal)
                cnt+=(r-l+1);
        }
        return cnt;
    }
}