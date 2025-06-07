class Solution {
    public List<String> validStrings(int n) {
        List<String> list=new ArrayList<>();
        valid(list,n,n,"",n,-1);
        return list;
    }

    public void valid(List<String> list,int one,int zero,String s,int n,int flag){
        if(s.length()>n){
            return;
        }
        if(s.length()==n){
            list.add(s);
            s="";
            return;
        }
        if(zero>0 && flag!=0)
        valid(list,one,zero-1,s+'0',n,0);
        if(one>0)
        valid(list,one-1,zero,s+'1',n,1);
    }
}