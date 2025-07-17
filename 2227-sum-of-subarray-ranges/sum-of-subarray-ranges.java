class Solution {
    public int[] nextSmaller(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) stack.pop();
            res[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        return res;
    }

    public int[] prevSmallerEqual(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) stack.pop();
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return res;
    }

    public long minSumSubarray(int[] arr) {
        int n = arr.length;
        int[] next = nextSmaller(arr);
        int[] prev = prevSmallerEqual(arr);
        long total = 0;
        for (int i = 0; i < n; i++) {
            long left = i - prev[i];
            long right = next[i] - i;
            total += left * right * 1L * arr[i];
        }
        return total;
    }

    public int[] nextGreaterEqual(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) stack.pop();
            res[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        return res;
    }

    public int[] prevGreater(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) stack.pop();
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return res;
    }

    public long maxSumSubarray(int[] arr) {
        int n = arr.length;
        int[] next = nextGreaterEqual(arr);
        int[] prev = prevGreater(arr);
        long total = 0;
        for (int i = 0; i < n; i++) {
            long left = i - prev[i];
            long right = next[i] - i;
            total += left * right * 1L * arr[i];
        }
        return total;
    }

    public long subArrayRanges(int[] nums) {
        return maxSumSubarray(nums) - minSumSubarray(nums);
    }
}