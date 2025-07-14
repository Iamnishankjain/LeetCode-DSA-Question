class Solution {
    public int trap(int[] arr) {
        int n=arr.length;
        int []pre=new int[n];
        int []suff=new int[n];
        pre[0]=arr[0];
        suff[n-1]=arr[n-1];
        for(int i=1;i<n;i++){
            pre[i]=Math.max(pre[i-1],arr[i]);
        }
        for(int i=n-2;i>=0;i--){
            suff[i]=Math.max(suff[i+1],arr[i]);
        }
        int total=0;
        for(int i=0;i<n;i++){
            int leftMax=pre[i],rightMax=suff[i];
            if(arr[i]<leftMax && arr[i]<rightMax){
                total+=Math.min(leftMax,rightMax)-arr[i];
            }
        }
        return total;
    }
}