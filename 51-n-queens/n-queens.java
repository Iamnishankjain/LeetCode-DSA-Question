class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> allBoards = new ArrayList<>();
        char[][] board = new char[n][n];
        helper(0,n,board,allBoards);
        return allBoards;
    }

    public void helper(int col,int n,char[][] board,List<List<String>> allBoards){
        if(col==n){
            add(board,n,allBoards);
            return;
        }
        for(int i=0;i<n;i++){
            if(isSafe(i,col,n,board)){
                board[i][col]='Q';
                helper(col+1,n,board,allBoards);
                board[i][col]='.';
            }
        }
    }
    public boolean isSafe(int row,int col,int n,char[][] board){
        for(int j=0;j<n;j++){
            if(board[row][j]=='Q') return false;
        }
        for(int i=row,j=col;i>=0 && j>=0;i--,j--){
            if(board[i][j]=='Q') return false;
        }
        for(int i=row,j=col;i<n && j>=0;i++,j--){
            if(board[i][j]=='Q') return false;
        }
        return true;
    }

    public void add(char[][] board,int n,List<List<String>> allBoards){
        String row="";
        List<String> list=new ArrayList<>();

        for(int i=0;i<n;i++){
            row="";
            for(int j=0;j<n;j++){
                if(board[i][j]=='Q'){
                    row+='Q';
                }
                else{
                    row+='.';
                }
            }
            list.add(row);
        }
        allBoards.add(list);
    }
}