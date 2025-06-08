class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        combine(0,0,new ArrayList<>(),target,candidates,candidates.length,res);
        return res;
    }

    public void combine(int ind,int sum,List<Integer> list,int target,int[] arr,int n,List<List<Integer>> res){
        if (sum > target) return;
        if(ind==n){
            if(sum==target)
                res.add(new ArrayList<>(list));
            return;
        }

        list.add(arr[ind]);
        combine(ind,sum+arr[ind],list,target,arr,n,res);
        list.remove(list.size()-1);
        combine(ind+1,sum,list,target,arr,n,res);
    }
}