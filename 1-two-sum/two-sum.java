class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        int arr[]=new int[2];
        for(int i=0;i<nums.length;i++){
            int diff=target-nums[i];
            if(!map.containsKey(diff)){
                map.put(nums[i],i);
            }
            else{
                arr[0]=i;
                arr[1]=map.get(diff); 
            }
        }
        return arr;
    }
}