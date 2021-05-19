package View;

import Model.Board.Symbol;
import Model.Players.Player;

import javax.swing.*;
import java.awt.*;

public class PlayerPanel extends JPanel {
        public JButton startBtn;
        public JButton selectBtn;

        public JLabel imgLabel;
        public JLabel playerName;

        public JLabel total;
        public JLabel won;
        public JLabel lost;

        public JLabel totalScore;
        public JLabel recentScore;

        public JLabel bestGames;

    public PlayerPanel(Symbol s, Player p){
        super();
        JLabel main = new JLabel();
        main.setBackground(Color.GREEN);
        main.setOpaque(true);
        main.setBounds(0,0,275,1100);

        startBtn = new JButton("Start Game");
        startBtn.setBounds(30, 5, 100, 25);
        main.add(startBtn);
        selectBtn = new JButton("Pick Player");
        selectBtn.setBounds(135, 5, 100, 25);
        main.add(selectBtn);

        imgLabel = new JLabel(getImageIcon(s.toString() + ".png", 100, 100));
        imgLabel.setBounds(75, 75, 100, 100);
        main.add(imgLabel);

        playerName = new JLabel(p.getName());
        playerName.setBounds(80, 175, 100, 50);
        main.add(playerName);

        total = new JLabel("Total: ");
        total.setBounds(15, 220, 250, 25);
        total.setFont(new Font("Arial", Font.PLAIN, 25));
        main.add(total);

        won = new JLabel("Won: ");
        won.setBounds(15, 250, 250, 25);
        won.setFont(new Font("Arial", Font.PLAIN, 25));
        main.add(won);

        lost = new JLabel("Lost: ");
        lost.setBounds(15, 280, 250, 25);
        lost.setFont(new Font("Arial", Font.PLAIN, 25));
        main.add(lost);

        totalScore = new JLabel("Total score: ");
        totalScore.setBounds(15, 330, 250, 25);
        totalScore.setFont(new Font("Arial", Font.PLAIN, 25));
        main.add(totalScore);

        recentScore = new JLabel("Recent score: ");
        recentScore.setBounds(15, 360, 250, 25);
        recentScore.setFont(new Font("Arial", Font.PLAIN, 25));
        main.add(recentScore);

        setToInitState();

        this.add(main);
        this.setLayout(null);
    }

    public void setName(String s) {
        this.playerName.setText(s);
    }

    public void setTotal(String s) {
        this.total.setText("Total: " + s);
    }

    public void setWon(String s) {
        this.won.setText("Won: " + s);
    }

    public void setLost(String s) {
        this.lost.setText("Lost: " + s);
    }

    public void setTotalScore(String s) {
        this.totalScore.setText("Total score: " + s);
    }

    public void setRecentScore(String s) {
        this.recentScore.setText("Recent score: " + s);
    }


    private ImageIcon getImageIcon(String filename, int width, int height){
        if(width == 0 || height == 0){
            return new ImageIcon(new ImageIcon(this.getClass().getResource("/Images/"+filename)).getImage());
        }
        return new ImageIcon(new ImageIcon(this.getClass().getResource("/Images/"+filename)).getImage().getScaledInstance(width,height, Image.SCALE_SMOOTH));
    }

    public void setToInitState() {
        playerName.setVisible(false);
        total.setVisible(false);
        won.setVisible(false);
        lost.setVisible(false);
        totalScore.setVisible(false);
        recentScore.setVisible(false);
    }

    public void setToGameState() {
        playerName.setVisible(true);
        total.setVisible(true);
        won.setVisible(true);
        lost.setVisible(true);
        totalScore.setVisible(true);
        recentScore.setVisible(true);
    }

    public JButton getStartBtn() {
        return startBtn;
    }

    public JButton getSelectBtn() {
        return selectBtn;
    }

    public JLabel getImgLabel() {
        return imgLabel;
    }

    public JLabel getPlayerName() {
        return playerName;
    }

    public JLabel getTotal() {
        return total;
    }

    public JLabel getWon() {
        return won;
    }

    public JLabel getLost() {
        return lost;
    }

    public JLabel getTotalScore() {
        return totalScore;
    }

    public JLabel getRecentScore() {
        return recentScore;
    }

    public JLabel getBestGames() {
        return bestGames;
    }
}
