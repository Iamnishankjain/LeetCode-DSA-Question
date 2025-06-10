class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list=new ArrayList<>();
        get(1,new ArrayList<>(),list,11,n,k);
        return list;
    }

    public void get(int st,List<Integer> ans,List<List<Integer>> list,int end,int target,int range){
        if(target<0 || ans.size()>range || st==end) return;
        if(ans.size()==range){
            if(target==0)
                list.add(new ArrayList<>(ans));
            return;
        }
        ans.add(st);
        get(st+1,ans,list,end,target-st,range);
        ans.remove(ans.size()-1);
        get(st+1,ans,list,end,target,range);
    }
}