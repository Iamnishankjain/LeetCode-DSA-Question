class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return numSubarrayslessSum(nums,k)-numSubarrayslessSum(nums,k-1);
    }
    public int numSubarrayslessSum(int[] nums, int goal) {
        if(goal<0) return 0;
        int cnt=0,sum=0;
        int l=0;
        for(int r=0;r<nums.length;r++){
            if(nums[r]%2!=0) sum+=1;
            while(sum>goal){
                if(nums[l]%2!=0) sum-=1;
                l++;
            }
            if(sum<=goal)
                cnt+=(r-l+1);
        }
        return cnt;
    }
}