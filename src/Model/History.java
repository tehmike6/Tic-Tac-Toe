package Model;

public class History {
    private int wins, loses, draws;
    private double score;
    private GameRecord[] latestGames, bestGames;

    public History() {
        this.wins = 0;
        this.loses = 0;
        this.latestGames = new GameRecord[5];
        this.bestGames = new GameRecord[5];
    }

    private void calculateScore() {
        score = ((double)(50 * ((2 * wins) + draws))) / getTotalGames();
    }

    public double getScore() {
        calculateScore();
        return score;
    }

    public void setScore(double score) { this.score = score; }

    public int getDraws() { return draws; }

    public void setDraws(int draws) { this.draws = draws; }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLoses() { return loses;
    }

    public void setLoses(int loses) {
        this.loses = loses;
    }

    public int getTotalGames() {
        return wins + loses + draws;
    }

    public GameRecord[] getLatestGames() {
        return latestGames;
    }

    public void setLatestGames(GameRecord[] latestGames) {
        this.latestGames = latestGames;
    }

    public GameRecord[] getBestGames() {
        return bestGames;
    }

    public void setBestGames(GameRecord[] bestGames) {
        this.bestGames = bestGames;
    }
}
