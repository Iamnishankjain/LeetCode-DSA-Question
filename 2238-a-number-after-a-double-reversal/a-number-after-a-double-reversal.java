class Solution {
    public boolean isSameAfterReversals(int num) {
        int original=rev(num);
        original=rev(original);
        return num==original;
    }

    int rev(int n){
        int re=0;
        while(n!=0){
            int rem=n%10;
            re=re*10+rem;
            n/=10;
        }
        return re;
    }
}