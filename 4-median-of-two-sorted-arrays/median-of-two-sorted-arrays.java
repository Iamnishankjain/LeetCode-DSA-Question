class Solution {
    public double findMedianSortedArrays(int[] a, int[] b) {
        int n1=a.length;
        int n2=b.length;
        int n=n1+n2;
        int i=0,j=0;
        int cnt=0;
        int ind2=n/2, ind1=ind2-1;
        int ele1=-1, ele2=-1;
        while(i<n1 && j<n2){
            if(a[i]<b[j]){
                if(cnt==ind1) ele1=a[i];
                if(cnt==ind2) ele2=a[i];
                cnt++;
                i++;
            }
            else{
                if(cnt==ind1) ele1=b[j];
                if(cnt==ind2) ele2=b[j];
                cnt++;
                j++;
            }
        }
        while(i<n1){
            if(cnt==ind1) ele1=a[i];
            if(cnt==ind2) ele2=a[i];
            cnt++;
            i++;
        }
        while(j<n2){
            if(cnt==ind1) ele1=b[j];
            if(cnt==ind2) ele2=b[j];
            cnt++;
            j++;
        }

        if(n%2!=1){
            return (ele2+ele1)/2.0;
        }
        return (double) ele2;
    }
}