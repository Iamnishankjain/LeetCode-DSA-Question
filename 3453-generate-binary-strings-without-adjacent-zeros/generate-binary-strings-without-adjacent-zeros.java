class Solution {
    public List<String> validStrings(int n) {
        List<String> list=new ArrayList<>();
        valid(list,"",n,-1);
        return list;
    }

    public void valid(List<String> list,String s,int n,int flag){
        if(s.length()==n){
            list.add(s);
            s="";
            return;
        }
        if(flag!=0)
        valid(list,s+'0',n,0);
        
        valid(list,s+'1',n,1);
    }
}