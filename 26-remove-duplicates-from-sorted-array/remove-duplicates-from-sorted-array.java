class Solution {
    public int removeDuplicates(int[] nums) {
        int c=1;
        int j=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[i-1]){
                nums[j]=nums[i];
                c++;
                j++;
            }
        }
        return c;
    }
}