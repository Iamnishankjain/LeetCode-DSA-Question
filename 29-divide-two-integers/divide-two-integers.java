class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend==divisor) return 1;
        int sign=1;
        if((dividend<0 && divisor>0)||(dividend>=0 && divisor<0)) sign=-1;

        long ans=0;
        long n=Math.abs((long)dividend);
        long d=Math.abs((long)divisor);

        while(n>=d){
            int cnt=0;
            while(n>=(d<<(cnt+1))){
                cnt++;
            }
            ans+=(1L<<cnt);
            n=n-(d<<cnt);
        }
        if(ans == (1L<<31) && sign==1) return Integer.MAX_VALUE;
        if(ans == (1L<<31) && sign==-1) return Integer.MIN_VALUE;
        int res=(int)ans;
        return sign==1 ? res : -res;
    }
}