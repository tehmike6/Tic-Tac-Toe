package View;

import javax.swing.*;
import java.awt.*;

public class HallOfFame extends JPanel {
    private String[][] scoreboard;
    private JPanel gridPanel;

    HallOfFame(){
        super();
        scoreboard = new String[10][2];
        this.setLayout(null);
        this.setBackground(Color.ORANGE);

        gridPanel = new JPanel(new GridLayout(10,1));
        gridPanel.setBackground(Color.ORANGE);
        JLabel title = new JLabel("Hall Of Fame");
        title.setFont(new Font("Arial",Font.PLAIN,30));
        title.setBounds(200,-10,300,50);
        this.add(title);
        this.add(gridPanel);
    }

    HallOfFame(String[][] table){
        super();
        scoreboard = new String[10][2];
        this.setLayout(null);
        this.setBackground(Color.ORANGE);

        scoreboard = table;

        gridPanel = new JPanel(new GridLayout(10,2));
        gridPanel.setBackground(Color.ORANGE);
        JLabel title = new JLabel("Hall Of Fame");
        title.setFont(new Font("Arial",Font.PLAIN,30));
        title.setBounds(200,-10,300,50);
        gridPanel.setBounds(0,0,550,800);
        this.add(title);
        this.add(gridPanel);

        updateHallOfFame(2);
    }

    public void updateScoreboard(String[][] scoreboard){
        this.scoreboard = scoreboard;
    }

    private void updateHallOfFame(int size) {
        JLabel[][] names = new JLabel[10][2];
        String temp;

        for(int i=0; i<size; i++){
            temp = i + ".  " + scoreboard[i][0] + "                     " + scoreboard[i][1];
            names[i][0] = new JLabel(temp);
            names[i][1] = new JLabel(temp);
            names[i][0].setFont(new Font("Arial",Font.PLAIN,25));
            names[i][1].setFont(new Font("Arial",Font.PLAIN,25));

            gridPanel.add(names[i][0]);
            gridPanel.add(names[i][1]);
        }
    }

}
