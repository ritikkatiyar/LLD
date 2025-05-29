package Team;

import Team.Player.Person;
import Team.Player.PlayerBattingController;
import Team.Player.PlayerBowlingController;
import Team.Player.PlayerDetails;

import java.util.List;
import java.util.Queue;

public class Team {
    String name;
    Queue<PlayerDetails> playing11;
    List<PlayerDetails> benchPlayers;
    PlayerBattingController playerBattingController;
    PlayerBowlingController playerBowlingController;
    public boolean isWinner;

    public Team(String teamName,Queue<PlayerDetails> playing11,List<PlayerDetails> benchPlayers,List<PlayerDetails> bowlers){
        this.name=teamName;
        this.playing11=playing11;
        this.benchPlayers=benchPlayers;
        playerBattingController=new PlayerBattingController(playing11);
        playerBowlingController=new PlayerBowlingController(bowlers);
    }
    public void chooseNextBatsMan() throws Exception{
        playerBattingController.getNextPlayer();
    }
    public void chooseNextBowler(int maxOverCountPerBowler){
        playerBowlingController.getNextBowler(maxOverCountPerBowler);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
