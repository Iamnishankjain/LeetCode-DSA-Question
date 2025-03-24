class Solution {
    public boolean search(int[] nums, int target) {
        int n=nums.length;
        int lb=0;
        int ub=n-1;
        while(lb<=ub){
            int mid=lb+(ub-lb)/2;
            if(nums[mid]==target){
                return true;
            }
            if(nums[mid]==nums[lb] && nums[lb]==nums[ub]){
                lb++;
                ub--;
                continue;
            }
            if(nums[lb]<=nums[mid]){
                if(nums[lb]<=target && nums[mid]>=target){
                    ub=mid-1;
                }
                else{
                    lb=mid+1;
                }
            }
            else{
                if(nums[mid]<=target && nums[ub]>=target){
                    lb=mid+1;
                }
                else{
                    ub=mid-1;
                }
            }
        }
        return false;
    }
}