
public class TennisGame1 implements TennisGame {
    
    private Player player1;
    private Player player2;
    private String result;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
        this.result = "Love-All";
    }

    public void wonPoint(String playerName) {
        if (player1.getName().equals(playerName))
            player1.increaseScore();
        else
            player2.increaseScore();
    }

    public String getScore() {
        String score = "";
        int tempScore=0;
        if (player1.getScore()==player2.getScore())
        {
            switch (player1.getScore())
            {
                case 0:
                        score = "Love-All";
                    break;
                case 1:
                        score = "Fifteen-All";
                    break;
                case 2:
                        score = "Thirty-All";
                    break;
                default:
                        score = "Deuce";
                    break;
                
            }
        }
        else if (player1.getScore()>=4 || player2.getScore()>=4)
        {
            int minusResult = player1.getScore()-player2.getScore();
            if (minusResult==1) score ="Advantage player1";
            else if (minusResult ==-1) score ="Advantage player2";
            else if (minusResult>=2) score = "Win for player1";
            else score ="Win for player2";
        }
        else
        {
            for (int i=1; i<3; i++)
            {
                if (i==1) tempScore = player1.getScore();
                else { score+="-"; tempScore = player2.getScore();}
                switch(tempScore)
                {
                    case 0:
                        score+="Love";
                        break;
                    case 1:
                        score+="Fifteen";
                        break;
                    case 2:
                        score+="Thirty";
                        break;
                    case 3:
                        score+="Forty";
                        break;
                }
            }
        }
        return score;
    }
}
