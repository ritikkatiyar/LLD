import java.util.ArrayList;
import java.util.List;

public class Board {
    public int size;
    public PlayingPiece[][] board;

    public Board(int size){
        this.size=size;
        board=new PlayingPiece[size][size];
    }
    //add peice on the playing board
    public boolean addPiece(int row,int column,PlayingPiece playingPiece){
        if(board[row][column]!=null){
            return false;
        }
        board[row][column]=playingPiece;
        return true;
    }
    public List<Pair> getFreeCells(){
        List<Pair> freeCells=new ArrayList<>();
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(board[i][j]==null){
                    Pair pair=new Pair(i,j);
                    freeCells.add(pair);
                }
            }
        }
        return freeCells;
    }
    public void printBoard(){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                System.out.print(board[i][j]+"|");
            }
            System.out.println();
        }
    }
}
