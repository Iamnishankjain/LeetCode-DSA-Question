class Solution {
    public double findMedianSortedArrays(int[] a, int[] b) {
        int n1=a.length;
        int n2=b.length;
        if(n1>n2){
            return findMedianSortedArrays(b,a);
        }
        int n=n1+n2;
        int left=(n1+n2+1)/2; 
        
        int low=0, high=n1;;
        while(low<=high){
            int mid1=(low+high)/2;
            int mid2=left-mid1; 
            int l1=Integer.MIN_VALUE,l2=Integer.MIN_VALUE;
            int r1=Integer.MAX_VALUE,r2=Integer.MAX_VALUE;
            if(mid1<n1) r1=a[mid1];
            if(mid2<n2) r2=b[mid2];
            if(mid1-1>=0) l1=a[mid1-1];
            if(mid2-1>=0) l2=b[mid2-1];

            if(l1<=r2 && l2<=r1){
                if(n%2==1){
                    return Math.max(l1,l2);
                }
                else{
                    return (Math.max(l1,l2)+Math.min(r1,r2))/2.0;
                }
            }
            else if(l1>r2){
                high=mid1-1;
            }
            else{
                low=mid1+1;
            }
        }
        return -1;
    }
}