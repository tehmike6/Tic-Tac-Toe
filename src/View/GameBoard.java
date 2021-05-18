package View;

import javax.swing.*;
import java.awt.*;

public class GameBoard extends JPanel {
    private JButton[][] TTT;
    private JLabel currentPlayer;

    public GameBoard(){
        super();

        TTT = new JButton[3][3];
        currentPlayer = new JLabel("main");


        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                TTT[i][j] = new JButton();
            }
        }

        JLabel tttImg = new JLabel();
        tttImg.setLayout(null);
        tttImg.setIcon(getImageIcon("Board.png",300,300));
        tttImg.setBounds(100,100,300,300);
        currentPlayer.setBounds(100,0,300,70);
        currentPlayer.setFont(new Font("Arial",Font.PLAIN,30));



        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                TTT[i][j].setBounds(100 + i*105,100 + j*105,90,90);
                TTT[i][j].setContentAreaFilled(false);
                TTT[i][j].setBorderPainted(false);
                this.add(TTT[i][j]);
            }
        }


        this.add(currentPlayer);
        this.add(tttImg);
        this.setLayout(null);
    }

    public void setCurrentPlayer(String playerName) {
        this.currentPlayer = new JLabel(playerName);;
    }

    public JButton[][] getTTT() {
        return TTT;
    }

    private ImageIcon getImageIcon(String filename, int width, int height){
        if(width == 0 || height == 0){
            return new ImageIcon(new ImageIcon(this.getClass().getResource("/Images/"+filename)).getImage());
        }
        return new ImageIcon(new ImageIcon(this.getClass().getResource("/Images/"+filename)).getImage().getScaledInstance(width,height, Image.SCALE_SMOOTH));
    }
}
