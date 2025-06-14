class Solution {
    public boolean exist(char[][] board, String word) {
       int n=board.length;
       int m=board[0].length;
       for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(find(i,j,0,board,word)){
                return true;
            }
        }
       }
       return false;
    }

    public boolean find(int i,int j,int ind,char[][] board,String word){
        int arr[][]={{1,0},{0,1},{-1,0},{0,-1}};
        if(ind==word.length()) return true;
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || board[i][j]=='$') return false;
        if(board[i][j]!=word.charAt(ind)) return false;

        char temp=board[i][j];
        board[i][j]='$';
        for(int dir[]: arr){
            int newI=i+dir[0];
            int newJ=j+dir[1];
            if(find(newI,newJ,ind+1,board,word)) return true;
        }
        board[i][j]=temp;
        return false;
    }
}