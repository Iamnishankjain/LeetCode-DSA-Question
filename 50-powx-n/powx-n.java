class Solution {
    public double myPow(double x, int pow) {
        long n=pow;
        double ans=1;
        int sign= n>=0 ? 1 : -1;
        if(n<0){
            n=-n;
        }
        while(n>0){
            if(n%2==1){
                ans*=x;
                n=n-1;
            }
            else{
                n=n/2;
                x=x*x;
            }
        }
        
        return sign==1 ? ans : (1.0/ans);
    }
}