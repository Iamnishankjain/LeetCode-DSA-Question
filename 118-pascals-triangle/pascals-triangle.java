class Solution {

    public ArrayList<Integer> rowWise(int row){
        ArrayList<Integer> list=new ArrayList<>();
        int ans=1;
        list.add(1);
        for(int c=1;c<row;c++){
            ans = ans * (row-c);
            ans/=c;
            list.add(ans);
        }
        return list;
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=1;i<=numRows;i++){
            List<Integer> temp=rowWise(i);
            ans.add(temp);
        }
        return ans;
    }
}