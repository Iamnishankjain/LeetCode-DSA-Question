class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low=1;
        int high=max(nums);
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(getDevisor(nums,mid,threshold)){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    public boolean getDevisor(int[] nums,int d,int t){
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=Math.ceil(nums[i]/(double)d);
        }
        return sum<=t;
    }
    public int max(int[] arr){
        int max=Integer.MIN_VALUE;

        for(int i=0;i<arr.length;i++){
            if(max<arr[i]){
                max=arr[i];
            }
        }
        return max;
    }
}