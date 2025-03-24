class Solution {
    public int[] searchRange(int[] nums, int target) {
        int f=first(nums,nums.length,target);
        if(f==nums.length || nums[f]!=target) return new int[]{-1,-1};
        int l=last(nums,nums.length,target);
        return new int[]{f,l-1};
    }

   public static int first(int []arr, int n, int x) {
        int ans=n;
        int lb=0;
        int ub=n-1;
        while(lb<=ub){
            int mid=lb+((ub-lb)/2);
            if(arr[mid]>=x){
                ans=mid;
                ub=mid-1;
            }
            else{
                lb=mid+1;
            }
        }
        return ans;
    }
    public static int last(int []arr, int n, int x){
        int ans=n;
        int lb=0;
        int ub=n-1;
        while(lb<=ub){
            int mid=lb+((ub-lb)/2);
            if(arr[mid]>x){
                ans=mid;
                ub=mid-1;
            }
            else{
                lb=mid+1;
            }
        }
        return ans;
    }
}