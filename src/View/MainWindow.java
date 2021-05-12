package View;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    public BannerPanel topPanel;
    public PlayerPanel leftPanel, rightPanel;
    public HallOfFame hof;
    public GameBoard board;

    private final int wndHeight = 800;
    private final int wndWidth = 1100;

    public MainWindow(){
        super();

        String[][] lol = new String[2][2];
        lol[0][0] = "Titan Lukas";
        lol[0][1] = "10000";
        lol[1][0] = "Mike";
        lol[1][1] = "100";

        topPanel = new BannerPanel();
        topPanel.setBounds(0,0,wndWidth,75);
        hof = new HallOfFame(lol);
        hof.setBounds(275,75,550,wndHeight);

        this.add(topPanel);
        this.add(hof);

        // Settings for the JFrame
        setSize(wndWidth, wndHeight);
        setBackground(Color.BLACK);
        setTitle("Tic Tac Toe");
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
