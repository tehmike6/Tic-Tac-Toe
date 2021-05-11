package Model;

public class History {
    private int wins, loses;
    private GameRecord[] latestGames, bestGames;

    public History() {
        this.wins = 0;
        this.loses = 0;
        this.latestGames = new GameRecord[5];
        this.bestGames = new GameRecord[5];
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLoses() {
        return loses;
    }

    public void setLoses(int loses) {
        this.loses = loses;
    }

    public int getTotalGames() {
        return wins + loses;
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
