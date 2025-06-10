class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        Arrays.sort(nums);
        subset(0,nums,new ArrayList<>(),list,nums.length);
        return list;
    }

    public void subset(int ind,int[] arr,List<Integer> ans,List<List<Integer>> list,int n){
        list.add(new ArrayList(ans));
        for(int i=ind;i<n;i++){
            if(i==ind || arr[i]!=arr[i-1]){
                ans.add(arr[i]);
                subset(i+1,arr,ans,list,n);
                ans.remove(ans.size()-1);
            }
        }
    }
}