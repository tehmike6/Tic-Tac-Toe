package View;

import javax.swing.*;
import java.awt.*;

public class HallOfFame extends JPanel {
    private String[] scoreboard;
    private JPanel gridPanel;

    HallOfFame(){
        super();
        scoreboard = new String[10];

        this.setLayout(null);
        this.setBackground(Color.ORANGE);

        gridPanel = new JPanel(new GridLayout(10,1));
        gridPanel.setBackground(Color.ORANGE);
        JLabel title = new JLabel("Hall Of Fame");
        title.setFont(new Font("Arial",Font.PLAIN,30));
        title.setBounds(200,-10,300,50);
        gridPanel.setBounds(0,20,550,650);

        this.add(title);
        this.add(gridPanel);
    }

    public void updateScoreboard(String[] scoreboard){
        this.scoreboard = scoreboard;
        updateHallOfFame();
    }

    private void updateHallOfFame() {
        JLabel[] names = new JLabel[10];
        String temp;

        for(int i=0; i<scoreboardSize(); i++){
            temp = (1+i) + ".  " + scoreboard[i];
            names[i] = new JLabel(temp);
            names[i].setFont(new Font("Arial",Font.PLAIN,25));

            gridPanel.add(names[i]);
        }
    }

    private int scoreboardSize(){
        int counter =0;
        for(String s : scoreboard) counter++;
        return counter;
    }

}
