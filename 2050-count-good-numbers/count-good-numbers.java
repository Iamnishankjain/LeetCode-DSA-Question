class Solution {
    public int countGoodNumbers(long n) {
        long even=(n+1)/2;
        long odd=n/2;

        long getEven=pow(5,even);
        long getOdd=pow(4,odd);
        long res=getEven*getOdd;
        return (int)(res%1000000007);
    }

    public long pow(long x,long n){
        if(n==0) return 1;

        long half=pow(x,n/2);
        long result=half*half;
        if(n%2==1){
            result*=x;
        }
        return result%1000000007;
    }
}