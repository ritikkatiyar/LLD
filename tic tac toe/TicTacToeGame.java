import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {
    Deque<Player> players;
    Board gameBoard;

    TicTacToeGame(){
        initializeGame();
    }
    public void initializeGame(){
        //creating two players
        players=new LinkedList<>();
        PlayingPieceX crossPiece=new PlayingPieceX();
        Player player1=new Player("player1",crossPiece);

        PlayingPieceO noughtsPiece=new PlayingPieceO();
        Player player2=new Player("player2",noughtsPiece);

        players.add(player1);
        players.add(player2);

        //initilize game board
        gameBoard=new Board(3);

    }
    public String startGame(){
        boolean noWinner=true;
        while(noWinner){
            //take out the player whose turn is
            Player playerTurn=players.removeFirst();

            //get the free space from the board
            gameBoard.printBoard();
            List<Pair> freeCells=gameBoard.getFreeCells();
            if(freeCells.isEmpty()){
                noWinner=false;
                continue;
            }
            /// read the user input
        System.out.print("Player "+playerTurn.getName()+" Enter row.column");
            Scanner inputScanner=new Scanner(System.in);
            String s=inputScanner.nextLine();
            String[] values=s.split(",");
            int rows=Integer.valueOf(values[0]);
            int columns=Integer.valueOf(values[1]);

            boolean placeThePiece= gameBoard.addPiece(rows,columns,playerTurn.getPlayingPiece());
            if(!placeThePiece){
                //player cannot insert the piece
                System.out.println("Incorrect position chosen,try again");
                players.addFirst(playerTurn);
                continue;
            }
            players.addLast(playerTurn);

            boolean winner=isThereWinner(rows,columns,playerTurn.playingPiece.pieceType);
            if(winner){
                return playerTurn.getName();
            }
        }
        return "tie";
    }
    public boolean isThereWinner(int row,int column,PieceType pieceType){
        return false;
    }
}
