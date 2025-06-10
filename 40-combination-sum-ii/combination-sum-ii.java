class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> ans=new ArrayList<>();
        getSubset(0,target,ans,candidates,candidates.length,res);
        return res;
    }

    public void getSubset(int ind,int target,List<Integer> ans,int[] arr,int n,List<List<Integer>> res){
        if(target==0){
            res.add(new ArrayList<>(ans));
            return;
        }
        if(ind==n || target<0){
            return;
        }
        for(int i=ind;i<n;i++){
            if(arr[i]>target) break;
            if(i==ind || arr[i]!=arr[i-1]){
                ans.add(arr[i]);
                getSubset(i+1,target-arr[i],ans,arr,n,res);
                ans.remove(ans.size()-1);
            }
        }
    }
}