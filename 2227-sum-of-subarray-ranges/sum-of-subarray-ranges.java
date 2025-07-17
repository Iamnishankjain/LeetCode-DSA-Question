class Solution {

    public int[] nse(int[] arr,int n){
        Stack<Integer> stack=new Stack<>();
        int nse[]=new int[n];
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]){
                stack.pop();
            }
            nse[i]=stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        return nse;
    }

    public int[] psee(int[] arr,int n){
        Stack<Integer> stack=new Stack<>();
        int psee[]=new int[n];
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && arr[stack.peek()]>arr[i]){
                stack.pop();
            }
            psee[i]=stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return psee;
    }
    public long minSumSubarray(int arr[]){
        int n=arr.length;
        int nse[]=nse(arr,n);
        int psee[]=psee(arr,n);
        long total=0;
        for(int i=0;i<n;i++){
            int left=i-psee[i];
            int right=nse[i]-i;
            total+=(right*left*1l*arr[i]);
        }
        return total;
    }

    public int[] ngee(int[] arr,int n){
        Stack<Integer> stack=new Stack<>();
        int ngee[]=new int[n];
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && arr[stack.peek()]<arr[i]){
                stack.pop();
            }
            ngee[i]=stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        return ngee;
    }

    public int[] pge(int[] arr,int n){
        Stack<Integer> stack=new Stack<>();
        int pge[]=new int[n];
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && arr[stack.peek()]<=arr[i]){
                stack.pop();
            }
            pge[i]=stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return pge;
    }
    public long maxSumSubarray(int arr[]){
        int n=arr.length;
        int ngee[]=ngee(arr,n);
        int pge[]=pge(arr,n);
        long total=0;
        for(int i=0;i<n;i++){
            int left=i-pge[i];
            int right=ngee[i]-i;
            total+=(right*left*1l*arr[i]);
        }
        return total;
    }
    public long subArrayRanges(int[] nums) {
        long max=maxSumSubarray(nums);
        long min=minSumSubarray(nums);
        return (max-min);
    }

    

}