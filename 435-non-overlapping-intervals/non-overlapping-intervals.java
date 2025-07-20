class Inter{
    int st;
    int end;
    Inter(int st,int end){
        this.st=st;
        this.end=end;
    }
}

class InterComparator implements Comparator<Inter>{
    public int compare(Inter a,Inter b){
        if(a.end>b.end) return 1;
        else if(a.end<b.end) return -1;
        return 0;
    }
}
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n=intervals.length;
        Inter arr[]=new Inter[n];
        for(int i=0;i<n;i++){
            arr[i]=new Inter(intervals[i][0],intervals[i][1]);
        }
        Arrays.sort(arr,new InterComparator());
        int free=arr[0].end,cnt=0;
        for(int i=1;i<n;i++){
            if(free<=arr[i].st){
                free=arr[i].end;
            }
            else{
                cnt++;
            }
        }
        return cnt;
    }
}