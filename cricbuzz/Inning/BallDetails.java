package Inning;

import ScoreUpdater.BattingScoreUpdater;
import ScoreUpdater.BowlingScoreUpdater;
import ScoreUpdater.ScoreUpdaterObserver;
import Team.Player.PlayerDetails;
import Team.Team;
import Team.Wicket;
import Team.WicketType;

import java.util.ArrayList;
import java.util.List;

public class BallDetails {
    public int ballNumber;
    public BallType ballType;
    public RunType runType;
    public PlayerDetails playedBy;
    public PlayerDetails bowledBy;
    public Wicket wicket;
    List<ScoreUpdaterObserver> scoreUpdaterObserverList=new ArrayList<>();


    public BallDetails(int ballNumber){
        this.ballNumber=ballNumber;
        scoreUpdaterObserverList.add(new BowlingScoreUpdater());
        scoreUpdaterObserverList.add(new BattingScoreUpdater());
    }

    public void startBallDelivery(Team battingTeam,Team bowlingTeam,OverDetails over){
        playedBy=battingTeam.getStriker();
    }
}
