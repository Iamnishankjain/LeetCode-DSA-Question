class Solution {
    public int search(int[] nums, int target) {
        int n=nums.length;
        int lb=0;
        int ub=n-1;
        do{
            int mid=lb+((ub-lb)/2);
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]<target){
                lb=mid+1;
            }
            else{
                ub=mid-1;
            }
        }while(lb<=ub);
        return -1;
    }
}