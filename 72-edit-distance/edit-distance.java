class Solution {
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        int memo[][]=new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(memo[i],-1);
        }
        return min(n-1,m-1,word1,word2,memo);
    }

    public int min(int i,int j,String word1, String word2,int memo[][]){
        if(i<0 && j<0) return 0;
        if(i<0){
            return j+1;
        }
        if(j<0){
            return i+1;
        }
        if(memo[i][j]!=-1) return memo[i][j];
        if(word1.charAt(i)==word2.charAt(j)){
            return min(i-1,j-1,word1,word2,memo);
        }
        int insert=1+min(i,j-1,word1,word2,memo);
        int replace=1+min(i-1,j-1,word1,word2,memo);
        int delete=1+min(i-1,j,word1,word2,memo);
        return memo[i][j]=Math.min(insert,Math.min(replace,delete));
    }
}