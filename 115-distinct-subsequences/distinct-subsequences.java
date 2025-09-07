class Solution {
    public int numDistinct(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();
        int memo[][]=new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(memo[i],-1);
        }
        return get(n-1,m-1,s1,s2,memo);
    }
    public static int get(int n,int m,String s1, String s2,int memo[][]){
        if(m<0) return 1;
        if(n<0) return 0;
        if(memo[n][m]!=-1) return memo[n][m];
        if(s1.charAt(n)==s2.charAt(m)){
            return memo[n][m]=get(n-1,m-1,s1,s2,memo)+get(n-1,m,s1,s2,memo);
        }
        else{
            return memo[n][m]=get(n-1,m,s1,s2,memo);
        }
    }
}