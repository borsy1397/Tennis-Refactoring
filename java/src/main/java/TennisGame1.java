
public class TennisGame1 implements TennisGame {

	private Player player1;
	private Player player2;
	
	/**
	 * From index 0 to 3 the results equals the player's score,
	 * from 4:
	 * RESULTS[4] = Deuce
	 * RESULTS[5] = Advantage for
	 * RESULTS[6] = Win for
	 */
	private static final String[] RESULTS = {"Love", "Fifteen", "Thirty", "Forty", "Deuce", "Advantage for", "Win for"};
	
	public TennisGame1(String player1Name, String player2Name) {
		this.player1 = new Player(player1Name);
		this.player2 = new Player(player2Name);
	}

	private boolean nameEquals(Player player, String playerName) {
		return player.getName().equals(playerName);
	}

	public void wonPoint(String playerName) {

		if (!(nameEquals(player1, playerName) || nameEquals(player2, playerName))) {
			throw new RuntimeException("There is no player in the game whose name is " + playerName + "!");
		}

		if (nameEquals(player1, playerName)) {
			player1.increaseScore();
		} else {
			player2.increaseScore();
		}
	}

	private String scoreEqual(int point) {
		
		if(point <= 2) {
			return RESULTS[point] + "-All";
		} else {
			return RESULTS[4];
		}
	}

	
	private String scoreGreaterThan3() {
		int minusResult = player1.getScore() - player2.getScore();
		
		if (minusResult == 1)
			return RESULTS[5] + " " + player1.getName();
		else if (minusResult == -1)
			return RESULTS[5] + " " + player2.getName();
		else if (minusResult >= 2)
			return RESULTS[6] + " " + player1.getName();
		else
			return RESULTS[6] + " " + player1.getName();
	}
	
	private String scoreLessThan4() {
		return RESULTS[player1.getScore()] + "-" + RESULTS[player2.getScore()];
	}
	
	public String getScore() {
		if (player1.getScore() == player2.getScore()) {
			return scoreEqual(player1.getScore());
		} else if (player1.getScore() >= 4 || player2.getScore() >= 4) {
			return scoreGreaterThan3();
		} else {
			return scoreLessThan4();
		}
	}
}
