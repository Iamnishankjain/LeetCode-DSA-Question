class Solution {
    public double myPow(double x, int n) {
        long nn=n;
        if (nn < 0) {
            nn = -nn;
            return 1.0 / recursive(x, nn);
        } else {
            return recursive(x, nn);
        }
    }

    public double recursive(double x, long n){
        if(n==0){
            return 1.0;
        }

        double half = recursive(x, n / 2);

        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
}