class Solution {
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int ind=-1;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                ind=i;
                break;
            }
        }

        if(ind==-1){
            reverse(nums,0,n-1);
            return;
        }
        else{
            for(int i=n-1;i>ind;i--){
                if(nums[ind]<nums[i]){
                    int temp=nums[ind];
                    nums[ind]=nums[i];
                    nums[i]=temp;
                    break;
                }
            }
            reverse(nums,ind+1,n-1);
        }
    }

    public void reverse(int[] nums,int i,int n){
        while(i<n){
            int temp=nums[i];
            nums[i]=nums[n];
            nums[n]=temp;
            i++;
            n--;
        }
    }
}