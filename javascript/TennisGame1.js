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
    this.scores[this.players.findIndex(function (el) {
        return el === playerName;
    })]++;
};

TennisGame1.prototype.getScore = function () {
    if (this.scores[0] === this.scores[1]) {
        return this.scoreEquals(this.scores[0]);
    } else if (this.scores[0] >= 4 || this.scores[1] >= 4) {
        return this.scoreGreaterThan3();
    } else {
        return this.scoreLessThan4();        
    }
};

if (typeof window === "undefined") {
    module.exports = TennisGame1;
}
