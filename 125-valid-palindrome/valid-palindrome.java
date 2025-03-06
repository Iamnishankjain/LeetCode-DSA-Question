class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(Character.isLetter(c) || Character.isDigit(c)) sb.append(Character.toLowerCase(c));
        }
        return check(sb.toString(),0);
    }

    public boolean check(String s,int lb){
        int n=s.length();
        if(lb>=n/2) return true;
        if(s.charAt(lb)!=s.charAt(n-lb-1)) return false;
        return check(s,lb+1);
    }
}