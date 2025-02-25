class Solution {
    public void sortColors(int[] nums) {
        int n=nums.length;
        int arr[]=new int[3];
        for(int i=0;i<n;i++){
            arr[nums[i]]++;
        }

        int i=0;
        while(i<n){
            for(int j=0;j<3;j++){
                for(int k=0;k<arr[j];k++){
                    nums[i]=j;
                    i++;
                }
            }
        }
    }
}