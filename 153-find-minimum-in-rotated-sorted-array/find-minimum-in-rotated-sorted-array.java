class Solution {
    public int findMin(int[] arr) {
        int lb=0;
        int n=arr.length;
        int ub=n-1;
        int ans=Integer.MAX_VALUE;
        while(lb<=ub){
            if(arr[lb]<=arr[ub]){
                ans = Math.min(ans,arr[lb]);
                break;
            }
            int mid=lb+(ub-lb)/2;
            if(arr[lb]<=arr[mid]){
                ans = Math.min(ans,arr[lb]);
                lb=mid+1;
            }
            else{
                ans = Math.min(ans,arr[mid]);
                ub=mid-1;
            }
        }
        return ans;
    }
}