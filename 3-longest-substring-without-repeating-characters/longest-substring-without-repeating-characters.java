import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int hash[]=new int[256];
        Arrays.fill(hash,-1);
        int l=0;
        int maxlen=0;
        for(int r=0;r<s.length();r++){
            if(hash[s.charAt(r)]!=-1){
                if(hash[s.charAt(r)]>=l)
                    l=hash[s.charAt(r)]+1;
            }
            maxlen=Math.max(maxlen,r-l+1);
            hash[s.charAt(r)]=r;
        }
        return maxlen;
    }
}
