class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> list=new ArrayList<>();
        if(digits.length()==0) return list;
        String map[]={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        solve(0,digits,new StringBuilder(""),digits.length(),map,list);
        return list;
    }

    public void solve(int ind,String s,StringBuilder ans,int n,String map[],List<String> list){
        if(ind>=n){
            list.add(ans.toString());
            return;
        }

        int val=s.charAt(ind)-'0';
        String str=map[val];
        for(int i=0;i<str.length();i++){
            ans.append(str.charAt(i));
            solve(ind+1,s,ans,n,map,list);
            ans.deleteCharAt(ans.toString().length()-1);
        }
    }
}