var TennisGame1 = function (player1Name, player2Name) {
    this.results = ["Love", "Fifteen", "Thirty", "Forty", "Deuce", "Advantage", "Win for"];
    this.players = [player1Name, player2Name];
    this.scores = [0, 0];
};

TennisGame1.prototype.scoreEquals = function (point) {
    if(point <= 2) {
        return this.results[point] + "-All";
    } else {
        return this.results[4]; //Deuce
    }
};

TennisGame1.prototype.scoreGreaterThan3 = function () {
    minusResult = this.scores[0] - this.scores[1];

    if (minusResult == 1)
        return this.results[5] + " " + this.players[0]; //Advantage
    else if (minusResult == -1)
        return this.results[5] + " " + this.players[1];
    else if (minusResult >= 2)
        return this.results[6] + " " + this.players[0]; //Win for
    else
        return this.results[6] + " " + this.players[1];
};

TennisGame1.prototype.scoreLessThan4 = function () {
    return this.results[this.scores[0]] + "-" + this.results[this.scores[0]];
};


TennisGame1.prototype.wonPoint = function (playerName) {
    if (playerName === "player1")
        this.m_score1 += 1;
    else
        this.m_score2 += 1;
};

TennisGame1.prototype.getScore = function () {
    if (this.scores[0] === this.scores[1]) {
        switch (this.m_score1) {
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
    } else if (this.scores[0] >= 4 || this.scores[1] >= 4) {
        var minusResult = this.m_score1 - this.m_score2;
        if (minusResult === 1) score = "Advantage player1";
        else if (minusResult === -1) score = "Advantage player2";
        else if (minusResult >= 2) score = "Win for player1";
        else score = "Win for player2";
    } else {
        for (var i = 1; i < 3; i++) {
            if (i === 1) tempScore = this.m_score1;
            else {
                score += "-";
                tempScore = this.m_score2;
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
    }
    return score;
};

if (typeof window === "undefined") {
    module.exports = TennisGame1;
}
