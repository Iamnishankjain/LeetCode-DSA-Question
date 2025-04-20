class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length;

        for(int i=0;i<n;i++){
            if(search(matrix[i],target)){
                return true;
            }
        }
        return false;
    }

    public boolean search(int arr[],int k){
        int low=0;
        int n=arr.length;
        int high=n-1;
        while(low<=high){
            int mid=(low+high)/2;

            if(arr[mid]==k){
                return true;
            }
            else if(arr[mid]>k){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return false;
    }
}