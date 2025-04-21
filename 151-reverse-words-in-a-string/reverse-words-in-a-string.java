class Solution {
    public String reverseWords(String s) {
        StringBuilder sb=new StringBuilder();
        String str[]=s.trim().replaceAll("\\s+", " ").split(" ");
        int n=str.length;
        reverse(str,n);
        for(int i=0;i<n-1;i++){
            sb.append(str[i]+" ");
        }
        sb.append(str[n-1]);
        return sb.toString();
    }

    public void reverse(String str[],int n){
        for(int i=0;i<n/2;i++){
            String temp=str[i];
            str[i]=str[n-i-1];
            str[n-i-1]=temp;
        }
    }
}