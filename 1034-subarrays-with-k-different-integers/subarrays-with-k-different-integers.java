class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return cntLessK(nums,k)-cntLessK(nums,k-1);
    }

    public int cntLessK(int nums[],int k){
        int cnt=0,l=0;
		int n=nums.length;
		HashMap<Integer,Integer> map=new HashMap<>();
		for(int r=0;r<n;r++){
			map.put(nums[r],map.getOrDefault(nums[r],0)+1);

			while(map.size()>k){
				map.put(nums[l],map.get(nums[l])-1);
				if(map.get(nums[l])==0) map.remove(nums[l]);
				l++;
			}
			if(map.size()<=k){
				cnt+=r-l+1;
			}
		}
		return cnt;
    }
}