class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list=new ArrayList<>();
        generate(list,"",n,0,0);
        return list;
    }
    public void generate(List<String> list,String s,int n,int open,int close){
        if(n*2==s.length()){
            list.add(s);
            return;
        }
        if(open<n)
        generate(list,s+"(",n,open+1,close);
        if(close<open)
        generate(list,s+")",n,open,close+1);
    }
}