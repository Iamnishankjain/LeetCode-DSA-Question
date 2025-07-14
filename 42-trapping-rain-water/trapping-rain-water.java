class Solution {
    public int trap(int[] arr) {
        int n=arr.length;
        int l=0,total=0,leftmax=0,rightmax=0;
        int r=n-1;
        while(l<r){
            if(arr[l]<=arr[r]){
                if(leftmax>arr[l]){
                    total+=leftmax-arr[l];
                }
                else{
                    leftmax=arr[l];
                }
                l++;
            }else{
                if(rightmax>arr[r]){
                    total+=rightmax-arr[r];
                }
                else{
                    rightmax=arr[r];
                }
                r--;
            }
        }
        return total;
    }
}