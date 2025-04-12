class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int n=piles.length;
        int low=1;
        int high=piles[n-1];
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(cal(piles,mid,h)){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }

    public boolean cal(int piles[],int mid,int h){
        int hour=0;
        for(int i=0;i<piles.length;i++){
            hour+=Math.ceil(piles[i]/(double)mid);
        }
        if(hour<=h){
            return true;
        }
        return false;
    }
}