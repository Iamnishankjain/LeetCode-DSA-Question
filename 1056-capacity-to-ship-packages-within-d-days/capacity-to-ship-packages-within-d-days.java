class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low=Arrays.stream(weights).max().getAsInt();
        int high=Arrays.stream(weights).sum();
        while(low<=high){
            int cap=low+(high-low)/2;
            int gDays=getDays(weights,cap);
            if(gDays<=days){
                
                high=cap-1;
            }
            else{
                low=cap+1;
            }
        }
        return low;
    }

    public int getDays(int[] weights,int cap){
        int days=1,load=0;

        for(int i=0;i<weights.length;i++){
            if(load+weights[i]>cap){
                days++;
                load=weights[i];
            }
            else{
                load+=weights[i];
            }
        }
        return days;
    }
}
