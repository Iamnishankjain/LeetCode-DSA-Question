class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        List<String> path=new ArrayList<>();
        get(0,s,s.length(),res,path);
        return res;
    }
    public void get(int ind,String s,int n,List<List<String>> res,List<String> path){
        if(ind==n){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i=ind;i<n;i++){
            if(ispalindrome(s,ind,i)){
                path.add(s.substring(ind,i+1));
                get(i+1,s,n,res,path);
                path.remove(path.size()-1);
            }
        }
    }

    public boolean ispalindrome(String s,int st,int end){
        while(st<=end){
            if(s.charAt(st++)!=s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}