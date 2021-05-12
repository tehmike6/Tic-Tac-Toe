package Model.Statistics;

import Model.Players.Player;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GameRecord {
    private Player p1, p2;
    private int winner; //1 for p1, 2 for p2, 0 for draw
    private long gameTime;

    public void GameRecord(Player p1, Player p2, int winner, long gameTime) {
        this.p1 = p1;
        this.p2 = p2;
        this.winner = winner;
        this.gameTime = gameTime;
    }

    public void saveGame() {
        Date d = new Date(System.currentTimeMillis());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        try {
            File f = new File("tictactoe.ser");
            if(!f.exists()) {
                f.createNewFile();
            }
            FileWriter w = new FileWriter(f.getName(), true);
            BufferedWriter bw= new BufferedWriter(w);
            bw.write("Game ended at: " + formatter.format(d) +
                    "\nPlayer1: " + p1.getName() + "\nPlayer2: " +  p2.getName() +
                    "\nScores: " + p1.getHistory().getScore() + " " + p2.getHistory().getScore() +
                    "\nWinner: " + winner + "\n\n");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
