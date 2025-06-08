class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        sub(0,list,new ArrayList<>(),nums);
        return list;
    }

    public void sub(int ind,List<List<Integer>> list,List<Integer> arr,int nums[]){
        if(ind>=nums.length){
            list.add(new ArrayList<>(arr));
            return;
        }

        arr.add(nums[ind]);
        sub(ind+1,list,arr,nums);
        arr.remove(arr.size()-1);
        sub(ind+1,list,arr,nums);
    }
}