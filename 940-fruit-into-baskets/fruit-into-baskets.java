class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> map=new HashMap<>();

        int l=0,maxlen=0,k=2;
        for(int r=0;r<fruits.length;r++){
            map.put(fruits[r],map.getOrDefault(fruits[r],0)+1);

            if(map.size()>k){
                map.put(fruits[l],map.get(fruits[l])-1);
                if(map.get(fruits[l])==0) map.remove(fruits[l]);
                l++;
            }
            if(map.size()<=k)
                maxlen=Math.max(maxlen,r-l+1);
        }
        return maxlen;
    }
}