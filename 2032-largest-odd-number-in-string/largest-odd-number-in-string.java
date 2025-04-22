class Solution {
    public String largestOddNumber(String str) {
        int n=str.length();
        String ans="";
        for(int i=n-1;i>=0;i--){
            char ch=str.charAt(i);
            int digit=ch-'0';
            if(digit%2==1){
                ans=str.substring(0,i+1);
                break;
            }
        }
        return ans;
    }
}