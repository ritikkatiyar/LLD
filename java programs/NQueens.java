import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> queens=new ArrayList<>();

        char[][] board=new char[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(board[i],'.');
        }
        solveNQueens(queens,board,0,n);
        return queens;
    }
    public void solveNQueens(List<List<String>> queens,char[][] board,int row,int n){
        if(row==n){
            queens.add(contructBoard(board));
            return;
        }

        for(int column=0;column<n;column++){
            if(canPlaceQueen(board,row,column,n)){
                board[row][column]='Q';
                solveNQueens(queens,board,row+1,n);
                board[row][column]='.';
            }

        }
    }
    public boolean canPlaceQueen(char[][] board,int row,int column,int n){
        //check down
        for(int i=0;i<row;i++){
            if(board[i][column]=='Q'){
                return false;
            }
        }
        //check right
        for(int i=0;i<column;i++){
            if(board[row][i]=='Q'){
                return false;
            }
        }
        //upper left diagonal
        for(int i=row-1,j=column-1;i>=0 && j>=0;i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        //upper right diagonal
        for(int i=row-1,j=column+1;i>=0 && j<n;i--,j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }
    public List<String> contructBoard(char[][] board){
        List<String> rows=new ArrayList<>();
        for(char[] row:board){
            rows.add(new String(row));
        }
        return rows;
    }
}