class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list=new ArrayList<>();
        int c1=0,c2=0,ele1=Integer.MIN_VALUE,ele2=Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++){
            if(c1==0 && nums[i]!=ele2){
                c1++;
                ele1=nums[i];
            }
            else if(c2==0 && nums[i]!=ele1){
                c2++;
                ele2=nums[i];
            }
            else if(ele1==nums[i]) c1++;
            else if(ele2==nums[i]) c2++;
            else{ c1--; c2--; }
        }


        c1=0;
        c2=0;
        for(int i=0;i<nums.length;i++){
            if(ele1==nums[i]) c1++;
            if(ele2==nums[i]) c2++;
        }
        if(c1>nums.length/3) list.add(ele1);
        if(c2>nums.length/3) list.add(ele2);
        return list;
    }
}