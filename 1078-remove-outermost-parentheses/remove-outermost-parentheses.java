class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb=new StringBuilder("");
        int n=s.length();
        int cnt=0;
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            if(c=='('){
                if(cnt>0){
                    sb.append(c);
                }
                cnt++;
            }
            else{
                cnt--;
                if(cnt>0){
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}