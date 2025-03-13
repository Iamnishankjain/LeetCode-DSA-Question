class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                swap(matrix,i,j);
            }
        }
        reverse(matrix);
    }

    public void swap(int arr[][],int i,int j){
        int temp=arr[i][j];
        arr[i][j]=arr[j][i];
        arr[j][i]=temp;
    }

    public void reverse(int arr[][]){
        for(int i=0;i<arr.length;i++){
            int lb=0,ub=arr.length-1;
            while(lb<ub){
                int temp=arr[i][lb];
                arr[i][lb]=arr[i][ub];
                arr[i][ub]=temp;
                lb++;
                ub--;
            }
        }
    }
}