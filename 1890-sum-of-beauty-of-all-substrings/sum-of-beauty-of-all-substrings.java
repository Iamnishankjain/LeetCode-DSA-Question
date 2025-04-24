class Solution {
    public int beautySum(String s) {
        int ans=0;
        int n=s.length();
        for(int size=3;size<=n;size++){
            int i=0;
            int j=size;
            int freq[]=new int[26];
            for(int k=i;k<j;k++){
                freq[s.charAt(k)-'a']++;
            }
            ans+=beauty(freq);
            while(j<n){
                freq[s.charAt(j)-'a']++;
                freq[s.charAt(i)-'a']--;
                ans+=beauty(freq);
                i++;
                j++;
            }
        }
        return ans;
    }
    public int beauty(int[] freq){
        int max=0;
        int n=freq.length;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(freq[i]!=0){
                max=Math.max(max,freq[i]);
                min=Math.min(min,freq[i]);
            }
        }
        return max-min;
    }
}