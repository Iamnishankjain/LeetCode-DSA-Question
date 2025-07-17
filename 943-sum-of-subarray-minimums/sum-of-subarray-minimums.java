class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n=arr.length;
        int nse[]=nse(arr,n);
        int psee[]=psee(arr,n);
        long total=0;
        int mod=(int)(1e9+7);
        for(int i=0;i<n;i++){
            int left=i-psee[i];
            int right=nse[i]-i;
            total=(total+(right*left*1L*arr[i])%mod)%mod;
        }
        return (int)total;
    }


    public int[] nse(int arr[],int n){
        int nse[]=new int[n];
        Stack<Integer> s=new Stack<>();

        for(int i=n-1;i>=0;i--){
            while(!s.isEmpty() && arr[s.peek()]>=arr[i]){
                s.pop();
            }
            nse[i]=s.isEmpty() ? n : s.peek();
            s.push(i);
        }
        return nse;
    }
    public int[] psee(int arr[],int n){
        int psee[]=new int[n];
        Stack<Integer> s=new Stack<>();

        for(int i=0;i<n;i++){
            while(!s.isEmpty() && arr[s.peek()]>arr[i]){
                s.pop();
            }
            psee[i]=s.isEmpty() ? -1 : s.peek();
            s.push(i);
        }
        return psee;
    }
}