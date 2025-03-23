class Solution {
    public int[] searchRange(int[] nums, int target) {
        int arr[]=new int[2];
        arr[0]=first(nums,target);
        arr[1]=last(nums,target);
        return arr;
    }

    public int first(int nums[],int target){
        int first=-1;
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]<target){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
            if(nums[mid]==target){
                first = mid;
            }
        }
        return first;
    }


    public int last(int nums[],int target){
        int last=-1;
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]<=target){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
            if(nums[mid]==target){
                last = mid;
            }
        }
        return last;
    }
}