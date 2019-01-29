
public class TennisGame1 implements TennisGame {

	private Player player1;
	private Player player2;
	private String result;

	public TennisGame1(String player1Name, String player2Name) {
		this.player1 = new Player(player1Name);
		this.player2 = new Player(player2Name);
		this.result = "Love-All";
	}

	private boolean nameEquals(Player player, String playerName) {
		return player.getName().equals(playerName);
	}

	public void wonPoint(String playerName) {

		if (!(nameEquals(player1, playerName) || nameEquals(player2, playerName))) {
			throw new java.lang.RuntimeException("There is no player in the game whose name is " + playerName + "!");
		}

		if (nameEquals(player1, playerName)) {
			player1.increaseScore();
		} else {
			player2.increaseScore();
		}
	}

	private String scoreEqual(int point) {
		switch (point) {
			case 0:
				return "Love-All";
			case 1:
				return "Fifteen-All";
			case 2:
				return "Thirty-All";
			default:
				return "Deuce";
		}
	}

	
	private String scoreGreaterThan3() {
		int minusResult = player1.getScore() - player2.getScore();
		
		if (minusResult == 1)
			return "Advantage " + player1.getName();
		else if (minusResult == -1)
			return "Advantage " + player2.getName();
		else if (minusResult >= 2)
			return "Win for " + player1.getName();
		else
			return "Win for " + player2.getName();
	}
	
	private String scoreLessThan4() {
		
		String[] results = {"Love", "Fifteen", "Thirty", "Forty"};
		
		return results[player1.getScore()] + "-" + results[player2.getScore()];
		
		
		/*String score = "";
		int tempScore = 0;
		for (int i = 1; i < 3; i++) {
			if (i == 1)
				tempScore = player1.getScore();
			else {
				score += "-";
				tempScore = player2.getScore();
			}
			switch (tempScore) {
			case 0:
				score += "Love";
				break;
			case 1:
				score += "Fifteen";
				break;
			case 2:
				score += "Thirty";
				break;
			case 3:
				score += "Forty";
				break;
			}
		}
		
		return score;*/
	}
	
	public String getScore() {
		String score = "";
		if (player1.getScore() == player2.getScore()) {
			return scoreEqual(player1.getScore());
		
		} else if (player1.getScore() >= 4 || player2.getScore() >= 4) {
			return scoreGreaterThan3();
			
		} else {
			return scoreLessThan4();
		}
	}
}
