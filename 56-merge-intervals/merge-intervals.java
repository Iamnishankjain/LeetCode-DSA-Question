class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> list=new ArrayList<>();
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        list.add(intervals[0]);

        for(int i=0;i<intervals.length;i++){
            int arr[]=list.get(list.size()-1);
            if(arr[1]>=intervals[i][0]){
                arr[0]=Math.min(arr[0],intervals[i][0]);
                arr[1]=Math.max(arr[1],intervals[i][1]);
                list.set(list.size()-1,arr);
            }
            else{
                list.add(intervals[i]);
            }
        }
        int arr[][]=new int[list.size()][2];
        for(int i=0;i<list.size();i++){
            arr[i][0]=list.get(i)[0];
            arr[i][1]=list.get(i)[1];
        }
        return arr;
    }
}