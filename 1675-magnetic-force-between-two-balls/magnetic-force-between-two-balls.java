class Solution {
    public int maxDistance(int[] stalls, int k) {
        Arrays.sort(stalls);
        int low=1;
        int high=stalls[stalls.length-1]-stalls[0];
        while(low<=high){
            int mid=low+(high-low)/2;
            if(canWeplace(stalls,mid,k)){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return high;
    }

    public static boolean canWeplace(int[] stalls,int dist,int k){
        int count=1, last=stalls[0];

        for(int i=1;i<stalls.length;i++){
            if(stalls[i]-last>=dist){
                count++;
                last=stalls[i];
            }
        }
        if(count>=k){
            return true;
        }
        return false;
    }
}