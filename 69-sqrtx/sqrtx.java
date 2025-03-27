class Solution {
    public int mySqrt(int x) {
        int lb=1;
        int ub=x/2+1;
        while(lb<=ub){
            int mid=lb+(ub-lb)/2;
            long square=(long)mid*mid;
            if(square==x){
                return mid;
            }
            else if(square>x){
                ub=mid-1;
            }
            else{
                lb=mid+1;
            }
        }
        return ub;
    }
}