class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        int n=intervals.length;
        List<int[]> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            int size=list.size()-1;
            if(list.isEmpty() || list.get(size)[1]<intervals[i][0]){
                list.add(new int[]{intervals[i][0],intervals[i][1]});
            }
            else{
                list.get(size)[1]=Math.max(list.get(size)[1],intervals[i][1]);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}