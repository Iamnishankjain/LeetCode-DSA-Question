class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        int n=nums.length;
        int noOfSubset= 1<<n;
        for(int num=0;num<noOfSubset;num++){
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<n;i++)
                if((num & (1<<i))!=0) list.add(nums[i]);
            res.add(list);
        }
        return res;
    }
}