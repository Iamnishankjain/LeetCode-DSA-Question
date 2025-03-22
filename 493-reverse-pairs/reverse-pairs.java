class Solution {
    public int reversePairs(int[] nums) {
        int count=0;
        count+=sort(nums,0,nums.length-1);
        return count;
    }
    public static int countpair(int []arr,int low,int mid,int high)
    {
        int count=0;
        int right=mid+1;
        for(int i=low;i<=mid;i++){
            while(right<=high && (long)arr[i]>2L*arr[right]){
                right++;
            }
            count+=(right-(mid+1));
        }
        return count;
    }
    public static int sort(int []arr,int p,int q){
        int count=0;
        if(p<q){
            int mid=p+(q-p)/2;
            count+=sort(arr,p,mid);
            count+=sort(arr,mid+1,q);
            count+=countpair(arr,p,mid,q);
            merge(arr,p,mid,q);
        }
        return count;
    }

    public static void merge(int []arr,int p,int mid,int q){
        int n1=mid-p+1;
        int n2=q-mid;

        int left[]=new int[n1];
        int right[]=new int[n2];

        for(int i=0;i<n1;i++){
            left[i]=arr[p+i];
        }
        for(int j=0;j<n2;j++){
            right[j]=arr[mid+j+1];
        }
        int i=0,j=0,k=p;
        while(i<n1 && j<n2){
            if(left[i]<=right[j]){
                arr[k++]=left[i++];
            }
            else{
                arr[k++]=right[j++];
            }
        }
        while(i<n1){
            arr[k++]=left[i++];
        }
        while(j<n2) arr[k++]=right[j++];

    }
}