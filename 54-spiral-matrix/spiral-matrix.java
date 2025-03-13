class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        ArrayList<Integer> list=new ArrayList<>();

        int left=0,right=m-1,top=0,bottom=n-1;
        while(left<=right && top<=bottom){
            for(int j=left;j<=right;j++){
                list.add(matrix[top][j]);
            }
            top++;
            for(int i=top;i<=bottom;i++){
                list.add(matrix[i][right]);
            }
            right--;
            if(top<=bottom)
            for(int j=right;j>=left;j--){
                list.add(matrix[bottom][j]);
            }
            bottom--;
            if(left<=right)
            for(int i=bottom;i>=top;i--){
                list.add(matrix[i][left]);
            }
            left++;
        }
        return list;
    }
}