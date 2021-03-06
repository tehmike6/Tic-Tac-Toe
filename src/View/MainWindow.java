package View;

import Model.Board.Symbol;
import Model.Players.Player;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    public BannerPanel topPanel;
    public PlayerPanel leftPanel, rightPanel;
    public HallOfFame hof;
    public GameBoard board;

    private final int wndHeight = 800;
    private final int wndWidth = 1100;

    public MainWindow(Player p1, Player p2){
        super();

        topPanel = new BannerPanel();
        topPanel.setBounds(0,0,wndWidth,75);

        hof = new HallOfFame();
        hof.setBounds(275,75,550,wndHeight);

        board = new GameBoard();
        board.setBounds(275,75,550,wndHeight);
        board.disableTTT();

        leftPanel = new PlayerPanel(Symbol.X, p1);
        leftPanel.setBounds(0,75,275,wndHeight);

        rightPanel = new PlayerPanel(Symbol.O, p2);
        rightPanel.setBounds(825,75,wndWidth,wndHeight);

        this.add(board);
        this.add(rightPanel);
        this.add(topPanel);
        this.add(hof);
        this.add(leftPanel);


        // Settings for the JFrame
        setResizable(false);
        setSize(wndWidth, wndHeight);
        setBackground(Color.BLACK);
        setTitle("Tic Tac Toe");
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
