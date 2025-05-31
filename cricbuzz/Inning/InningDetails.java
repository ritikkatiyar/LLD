package Inning;

import Team.Team;

import java.util.ArrayList;
import java.util.List;

public class InningDetails {
    Team battingTeam;
    Team bowlingTeam;
    List<OverDetails> overs;
    MatchType matchType;

    public InningDetails(Team battingTeam,Team bowlingTeam,MatchType matchType){
        this.battingTeam=battingTeam;
        this.bowlingTeam=bowlingTeam;
        this.matchType=matchType;
        overs=new ArrayList<>();
    }
    public void start(int runToWin){
        //set batting pplayers
        try{
            battingTeam.chooseNextBatsMan();
        }catch (Exception e){
            e.printStackTrace();
        }
        int noOfOvers=matchType.noOfOvers();
        for(int overNumber=1;overNumber<=noOfOvers;overNumber++){
            //choose bowler
            bowlingTeam.chooseNextBowler(matchType.maxOverCountBowlers());

            OverDetails over=new OverDetails();
        }
    }

}
