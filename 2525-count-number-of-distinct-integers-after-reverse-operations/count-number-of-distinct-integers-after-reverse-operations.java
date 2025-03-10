class Solution {
    public int countDistinctIntegers(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            int rev=reverse(nums[i]);
            set.add(nums[i]);
            set.add(rev);
        }
        return set.size();
    }

    int reverse(int n){
        int rev=0;
        while(n!=0){
            rev=rev*10+(n%10);
            n/=10;
        }
        return rev;
    }
}