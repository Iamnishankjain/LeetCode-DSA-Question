class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb=new StringBuilder("");
        Arrays.sort(strs);
        int n=strs.length;
        String first=strs[0];
        String last=strs[n-1];

        for(int i=0;i<first.length();i++){
            if(first.charAt(i)!=last.charAt(i)){
                break;
            }
            sb.append(first.charAt(i));
        }
        return sb.toString();
    }
}