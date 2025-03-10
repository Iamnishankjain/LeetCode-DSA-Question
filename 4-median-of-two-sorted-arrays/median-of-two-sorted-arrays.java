class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length+nums2.length;
        int arr[]=new int[n];
        int c=0;
        for(int i=0;i<nums1.length;i++){
            arr[c++]=nums1[i];
        }
        for(int i=0;i<nums2.length;i++){
            arr[c++]=nums2[i];
        }
        Arrays.sort(arr);
        if(n%2!=0){
            return (double)(arr[n/2]);
        }
        double mid1=(double)arr[n/2];
        double mid2=(double)arr[(n/2)-1];
        double result = (mid1+mid2)/2.0;
        return result;
    }
}