class Solution {
    public int myAtoi(String s) {
        s=s.trim();
        if(s.length()==0) return 0;
        int i=0;
        int sign=1;
        if(s.charAt(0)=='-' || s.charAt(0)=='+'){
            if(s.charAt(0)=='-'){
                sign=-1;
            }
            i++;
        }
        return atoid(s,0,i,s.length(),sign);
    }
    public int atoid(String s,int num,int i,int n,int sign){
        if(i==n || !Character.isDigit(s.charAt(i))){
            return num*sign;
        }
        int digit=s.charAt(i)-'0';
        if (num > (Integer.MAX_VALUE - digit) / 10) {
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        return atoid(s,num*10+digit,i+1,n,sign);
    }
}
