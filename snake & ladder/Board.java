import java.util.Random;

public class Board {
    private int size;
    private Cell[][] cells;
    private Random random;


    public Board(int size,int numberOfSnakes,int numberOfLadders){
        this.size=size;
        random=new Random();
        cells=new Cell[size][size];
        intializeCells();
        addSnakes(numberOfSnakes);
        addLadders(numberOfLadders);
    }
    public void intializeCells(){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                cells[i][j]=new Cell();
            }
        }
    }
    public void addSnakes(int numberOfSnakes){
        int i=0;
        while(i<numberOfSnakes){

            int snakeHead = random.nextInt(size * size - 1) + 1; // avoid 0
            int snakeTail = random.nextInt(size * size - 1) + 1;
            if(snakeTail>snakeHead){
                continue;
            }
            Jump snake=new Jump("snake",snakeHead,snakeTail);
            getCell(snakeHead).setJump(snake);
            i++;
        }
    }
    public void addLadders(int numberOfLadders){
        int i=0;
        while(i<numberOfLadders){

            int ladderHead = random.nextInt(size * size - 1) + 1; // avoid 0
            int ladderTail = random.nextInt(size * size - 1) + 1;
            if(ladderHead>ladderTail){
                continue;
            }
            Jump ladder=new Jump("ladder",ladderHead,ladderTail);
            getCell(ladderHead).setJump(ladder);
            i++;
        }

    }
    public Cell getCell(int position){
        int row=position/10;
        int column=position%10;
        return cells[row][column];
    }


}
