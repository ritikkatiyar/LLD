import java.util.Deque;
import java.util.LinkedList;

public class Game {
    private Deque<Player> players;
    private Board board;
    private Dice dice;


    public Game(){
        initilizeGame();
    }
    public void initilizeGame(){
        players = new LinkedList<>();
        Player player1 = new Player("ritik", 0);
        Player player2 = new Player("vivek", 0);
        players.add(player1);
        players.add(player2);

        board = new Board(10, 4, 4); // 10x10 board, 4 snakes, 4 ladders
        dice = new Dice(1, 6); // standard one 6-faced dice

        startGame();
    }
    private void startGame(){
        boolean winnerFound=false;
        while(!winnerFound){
            Player currentPlayer=players.pollFirst();
            int currentPosition= currentPlayer.getNextPosition();

            int diceRoll= dice.rollDice();
            int nextposition=currentPosition+diceRoll;

            if(nextposition>99){
                players.addLast(currentPlayer);
            }else{
                Cell cell= board.getCell(nextposition);
                if(cell.getJump()!=null){
                    Jump jump=cell.getJump();
                    nextposition=jump.getEnd();
                    System.out.println(currentPlayer.getId()+ " got "+jump.getName());
                }
                currentPlayer.setNextPosition(nextposition);
                System.out.println(currentPlayer.getId() + " rolled a " + diceRoll + " and moved to " + nextposition);

                if (nextposition == 99) {
                    System.out.println(currentPlayer.getId() + " wins the game!");
                    winnerFound = true;
                } else {
                    players.addLast(currentPlayer);
                }
            }
        }
    }
}
