class Solution {
    public int splitArray(int[] nums, int k) {
        int low=Arrays.stream(nums).max().getAsInt();
        int high=Arrays.stream(nums).sum();

        while(low<=high){
            int mid=low+(high-low)/2;
            int currK=findK(nums,mid);
            if(currK<=k){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
    public int findK(int[] nums,int k){
        int split=1, ks=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]+ks<=k){
                ks+=nums[i];
            }
            else{
                split++;
                ks=nums[i];
            }
        }
        return split;
    }
}