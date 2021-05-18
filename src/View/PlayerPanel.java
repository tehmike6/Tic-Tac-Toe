package View;

import javax.swing.*;
import java.awt.*;

public class PlayerPanel extends JPanel {
        public JButton startBtn;
        public JButton selectBtn;

        public JLabel imgLabel;
        public JLabel name;

        public JLabel total;
        public JLabel won;
        public JLabel lost;

        public JLabel totalScore;
        public JLabel recentScore;

        public JLabel bestGames;

    public PlayerPanel(){
        super();
        JLabel main = new JLabel();
        main.setBackground(Color.GREEN);
        main.setOpaque(true);
        main.setBounds(0,0,275,1100);

        this.add(main);
        this.setLayout(null);
    }
}
