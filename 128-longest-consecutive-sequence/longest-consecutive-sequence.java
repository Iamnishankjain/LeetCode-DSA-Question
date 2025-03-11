class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        Arrays.sort(nums);
        int max=1,small=nums[0];
        int count=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]-1==small){
                count++;
                small=nums[i];
            }
            else if(small!=nums[i]){
                count=1;
                small=nums[i];
            }
            max=Math.max(max,count);
        }
        return max;
    }
}