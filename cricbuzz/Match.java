import Inning.InningDetails;
import Inning.MatchType;
import Team.Team;

import java.util.Date;

public class Match {
    Team teamA;
    Team teamB;
    Date matchDate;
    String venue;
    InningDetails[] inning;
    MatchType matchType;
    Team tossWinner;

    public Match(Team teamA,Team teamB,Date matchDate,String venue,MatchType matchType){
        this.teamA=teamA;
        this.teamB=teamB;
        this.matchDate=matchDate;
        this.venue=venue;
        inning=new InningDetails[2];
        this.matchType=matchType;
    }
    public void startMatch(){

        //toss
        tossWinner=toss(teamA,teamB);
        //start the inning ,there are 2 innings in a match
        for(int inning=1;inning<=2;inning++){
            InningDetails inningDetails;

            Team bowlingTeam;
            Team battingTeam;
            //assuming that here tossWinner batFirst
            if(inning==1){
                battingTeam=tossWinner;
                bowlingTeam=tossWinner.getName().equals(teamA.getName())?teamB:teamA;
                inningDetails=new InningDetails(battingTeam,bowlingTeam,matchType);

            }
        }
    }

    private Team toss(Team teamA, Team teamB) {
        //random function returns value between o and 1
        if(Math.random()<0.5){
            return teamA;
        }else{
            return teamB;
        }
    }
}
