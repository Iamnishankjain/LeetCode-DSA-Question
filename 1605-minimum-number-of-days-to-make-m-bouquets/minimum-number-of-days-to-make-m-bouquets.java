class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if(bloomDay.length<(long)(m*k)) return -1;
        int low=min(bloomDay);
        int high=max(bloomDay);
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            int total=totalDays(bloomDay,k,mid,m);
            if(total!=-1){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    public int totalDays(int[] bloomDay,int k,int low,int m){
        int total=0;
        int count=0;
        for(int i=0;i<bloomDay.length;i++){
            if(bloomDay[i]<=low){
                count++;
            }
            else{
                total+=count/k;
                count=0;
            }
        }
        total+=count/k;
        if(m<=total){
            return low;
        }
        else return -1;
    }
    public int min(int[] arr){
        int min=Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            if(min>arr[i]) min=arr[i];
        }
        return min;
    }
    public int max(int[] arr){
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(max<arr[i]) max=arr[i];
        }
        return max;
    }
}