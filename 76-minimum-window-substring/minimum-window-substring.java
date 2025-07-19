class Solution {
    public String minWindow(String s, String t) {
        int minlen=Integer.MAX_VALUE,l=0,st=-1,end=-1,cnt=0;
        int hash[]=new int[256];
        for(int i=0;i<t.length();i++){
            hash[t.charAt(i)]++;
        }

        for(int r=0;r<s.length();r++){
            char rch=s.charAt(r);
            if(hash[rch]>0){
                cnt++;
            }
            hash[rch]--;
            while(cnt==t.length()){
                if(minlen>(r-l+1)){
                    minlen=r-l+1;
                    st=l;
                    end=r;
                }
                hash[s.charAt(l)]++;
                if(hash[s.charAt(l)]>0) cnt--;
                l++;
            }
        }
        return st==-1 ? "" : s.substring(st,end+1);
    }
}