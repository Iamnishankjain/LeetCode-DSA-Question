class Solution {
    public List<String> addOperators(String s, int target) {
        List<String> list=new ArrayList<>();
        solve(0,s,target,"",list,0,0);
        return list;
    }

    public void solve(int ind,String s,int target,String path,List<String> list,long eval,long residual){
        if(ind==s.length()){
            if(eval==target)
                list.add(path);
            return;
        }
        String currStr="";
        long num=0;
        for(int i=ind;i<s.length();i++){
            if(i>ind && s.charAt(ind)=='0') break;
            currStr+=s.charAt(i);
            num=num*10+s.charAt(i)-'0';
            if(ind==0){
                solve(i+1,s,target,path+currStr,list,num,num);
            }
            else{
                solve(i+1,s,target,path+"+"+currStr,list,eval+num,num);
                solve(i+1,s,target,path+"-"+currStr,list,eval-num,-num);
                solve(i+1,s,target,path+"*"+currStr,list,eval-residual+residual*num,residual*num);
            }
        }
    }
}