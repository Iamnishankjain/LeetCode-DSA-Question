class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n<0) return 0;
        if(n==1) return nums[0]; 
        int one=rob1(nums,0,n-1);
        int two=rob1(nums,1,n);
        return Math.max(one,two);
    }
    public int rob1(int[] nums,int st,int end) {
        int prev2=0;
        int prev=nums[st];
        for(int i=st+1;i<end;i++){
            int pick=nums[i];
            if(i-2>=st){
                pick+=prev2;
            }
            int curr=Math.max(prev,pick);
            prev2=prev;
            prev=curr;
        }
        return prev;
    }
}