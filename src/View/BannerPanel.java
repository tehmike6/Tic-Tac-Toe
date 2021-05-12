package View;

import javax.swing.*;
import java.awt.*;

public class BannerPanel extends JPanel {
    JButton quitBtn, addPlayerBtn, doneBtn;

    BannerPanel(){
        super();
        this.setLayout(null);
        this.setBackground(Color.GRAY);

        quitBtn = new JButton("Quit");
        addPlayerBtn = new JButton("Add Player");
        doneBtn = new JButton("Done");

        quitBtn.setBounds(20,22,100,30);
        quitBtn.setFont(new Font("Arial", Font.PLAIN,12));
        addPlayerBtn.setBounds(120,22,100,30);
        addPlayerBtn.setFont(new Font("Arial", Font.PLAIN,12));
        doneBtn.setBounds(500,22,100,30);
        doneBtn.setFont(new Font("Arial", Font.PLAIN,12));

        this.add(doneBtn);
        this.add(addPlayerBtn);
        this.add(quitBtn);
    }

    public JButton getQuit() {
        return quitBtn;
    }

    public JButton getAddPlayer() {
        return addPlayerBtn;
    }

    public JButton getDone() {
        return doneBtn;
    }
}
