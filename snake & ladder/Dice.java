import java.util.Random;

public class Dice {
    private int numberOfFaces;
    private int diceCount;
    private Random random;

    public Dice(int diceCount,int numberOfFaces) {
        this.diceCount = diceCount;
        this.numberOfFaces=numberOfFaces;
        this.random=new Random();
    }
    public int rollDice(){
        int total=0;
        for(int i=0;i<diceCount;i++){
            total+=random.nextInt(numberOfFaces)+1;
        }
        return total;
    }
}
