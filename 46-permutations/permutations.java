class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list1=new ArrayList<>();
        backtrack(nums,0,list1);
        return list1;
    }

    public void backtrack(int[] nums,int start,List<List<Integer>> result) {
        if(nums.length==start){
            List<Integer> curr=new ArrayList<>();
            for(int i:nums){
                curr.add(i);
            }
            result.add(curr);
            return;
        }

        for(int i=start;i<nums.length;i++){
            swap(nums,start,i);
            backtrack(nums,start+1,result);
            swap(nums,start,i);
        }
    }

    public void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

}