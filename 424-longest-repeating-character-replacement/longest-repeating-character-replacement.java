class Solution {
    public int characterReplacement(String s, int k) {
        int l=0,maxlen=0,maxfreq=0;
        int hash[]=new int[26];
        for(int r=0;r<s.length();r++){
            int ind=s.charAt(r)-'A';
            hash[ind]++;
            maxfreq=Math.max(maxfreq,hash[ind]);
            if(((r-l+1)-maxfreq)>k){
                hash[s.charAt(l)-'A']--;
                // maxfreq=0;
                l++;
            }
            if(((r-l+1)-maxfreq)<=k){
                maxlen=Math.max(maxlen,r-l+1);
            }
        }
        return maxlen;
    }
}