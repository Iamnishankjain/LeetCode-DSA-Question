class Solution {
    public int findPeakElement(int[] arr) {
        int n=arr.length;
        if (n == 1) return 0;
        if (arr[0] > arr[1]) return 0;
        if (arr[n - 1] > arr[n - 2]) return n - 1;
        int lb=1;
        int ub=n-2;
        while(lb<=ub){
            int mid=lb+(ub-lb)/2;
            if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]) return mid;
            else if(arr[mid]>arr[mid+1]){
                ub=mid-1;
            }
            else{
                lb=mid+1;
            }
        }
        return -1;
    }
}