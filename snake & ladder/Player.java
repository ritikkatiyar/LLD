public class Player {
    private String id;
    private int nextPosition;

    public Player(String id, int nextPosition) {
        this.id = id;
        this.nextPosition = nextPosition;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNextPosition() {
        return nextPosition;
    }

    public void setNextPosition(int nextPosition) {
        this.nextPosition = nextPosition;
    }
}
