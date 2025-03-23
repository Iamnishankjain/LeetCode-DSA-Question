class Solution {
    public int maxProduct(int[] arr) {
        int max=Integer.MIN_VALUE;
        int n=arr.length;
        int pre=1;
        int suff=1;
        for(int i=0;i<n;i++){
            if(pre==0) pre=1;
            if(suff==0) suff=1;
            suff*=arr[n-i-1];
            pre*=arr[i];
            max=Math.max(Math.max(suff,pre),max);
        }
        return max;
    }
}