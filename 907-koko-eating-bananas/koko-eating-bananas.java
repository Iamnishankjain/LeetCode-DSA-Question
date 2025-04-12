class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n=piles.length;
        int low=1;
        int high=max(piles);
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

    public int max(int arr[]){
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(max<arr[i]) max=arr[i];
        }
        return max;
    }
}