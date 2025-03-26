class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n=nums.length;
        if(n==1 || nums[0]!=nums[1]) return nums[0];
        if(nums[n-1]!=nums[n-2]) return nums[n-1];

        int lb=1;
        int ub=n-1;
        while(lb<=ub){
            int mid=lb+(ub-lb)/2;
            if(nums[mid]!= nums[mid+1] && nums[mid-1]!=nums[mid]){
                return nums[mid];
            }
            // on left
            else if((mid%2==1 && nums[mid-1]==nums[mid]) || (mid%2==0 && nums[mid+1]==nums[mid])){
                lb=mid+1;
            }
            else{
                ub=mid-1;
            }
        }
        return -1;
    }
}