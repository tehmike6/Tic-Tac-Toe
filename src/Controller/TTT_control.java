package Controller;

import Model.Board.Board;
import Model.Board.Symbol;
import Model.Helpers.ForbiddenPlayerNameExc;
import Model.Players.Hal;
import Model.Players.HumanPlayer;
import Model.Players.MrBean;
import Model.Players.Player;
import Model.Statistics.PlayerRoster;
import View.MainWindow;
import View.PlayerPanel;

import javax.swing.*;
import java.sql.SQLOutput;

public class TTT_control {
    private MainWindow mainWindow;
    private Board board;
    private PlayerRoster roster;
    private boolean gameStartFlag1, gameStartFlag2;

    public void initGame() {
        initActionListeners();
        try{
            roster.addPlayer(new Hal());
            roster.addPlayer(new MrBean());
        }
        catch(Exception e){
            System.out.println(e);
        }
        mainWindow.leftPanel.getStartBtn().setEnabled(false);
        mainWindow.rightPanel.getStartBtn().setEnabled(false);

    }

    public TTT_control(Player p1, Player p2) {
        this.mainWindow = new MainWindow(p1, p2);
        this.board = new Board(p1, p2);
        this.roster = new PlayerRoster();
        gameStartFlag1 = false;
        gameStartFlag2 = false;
        initGame();
    }

    private void initActionListeners() {
        for(int k = 0; k < 3; k++) {
            for(int m = 0; m < 3; m++) {
                mainWindow.board.TTT[k][m].addActionListener(e -> {
                    int i, j;
                    for( i = 0; i < 3; i++) {
                        for( j = 0; j < 3; j++) {
                            if(e.getSource() == mainWindow.board.TTT[i][j]) {
                                if(board.getT()[i][j] != Symbol.NONE) {
                                    return;
                                }
                                if(board.getTurn() == 1) {
                                    board.getTicTacToe().setTTT(i, j, Symbol.X);
                                    mainWindow.board.setButtonIcon(i, j, 1);
                                }
                                else {
                                    board.getTicTacToe().setTTT(i, j, Symbol.O);
                                    mainWindow.board.setButtonIcon(i, j, 2);
                                }
                                board.nextTurn();
                                if(board.getTicTacToe().checkForWin(Symbol.X)){
                                    System.out.println("X wins"); //TODO: add more
                                    System.out.println(board.getTotalTime());
                                    board.getP1().getHistory().incWins();
                                    board.getP2().getHistory().incLoses();
                                    endGame();
                                }
                                else if(board.getTicTacToe().checkForWin(Symbol.O)) {
                                    System.out.println("O wins");
                                    board.getP2().getHistory().incWins();
                                    board.getP1().getHistory().incLoses();
                                    endGame();
                                }
                                else if(board.getTicTacToe().isBoardFull()) {
                                    System.out.println("pat");
                                    board.getP1().getHistory().incDraws();
                                    board.getP2().getHistory().incDraws();
                                    endGame();
                                }
                            }
                        }
                    }
                });
            }
        }
        mainWindow.topPanel.getQuit().addActionListener(e -> {
            System.exit(0);
        });
        mainWindow.topPanel.getDone().addActionListener(e -> {
            mainWindow.topPanel.getDone().setEnabled(false);
            mainWindow.leftPanel.setToInitState();
            mainWindow.rightPanel.setToInitState();
            mainWindow.leftPanel.getSelectBtn().setEnabled(true);
            mainWindow.rightPanel.getSelectBtn().setEnabled(true);
            mainWindow.board.setVisible(false);
            mainWindow.hof.setVisible(true);
            mainWindow.board.resetButtons();
        });

        mainWindow.topPanel.getAddPlayer().addActionListener(e -> {
            String name = JOptionPane.showInputDialog(mainWindow,
                    "Please enter the new player's name", null);
            try {
                roster.addPlayer(new HumanPlayer(name));
            } catch (ForbiddenPlayerNameExc forbiddenPlayerNameExc) {
                System.out.println(forbiddenPlayerNameExc.toString());
                return;
            }
        });

        mainWindow.leftPanel.getSelectBtn().addActionListener(e -> {
            Player p = (Player) JOptionPane.showInputDialog(mainWindow, "Select a player...", "Player Selection",
                    JOptionPane.PLAIN_MESSAGE,UIManager.getIcon("FileChooser.newFolderIcon"),
                    roster.getRoster().getTable(), roster.getRoster().get(1));
            setPlayerStats(p, mainWindow.leftPanel);
            mainWindow.leftPanel.getStartBtn().setEnabled(true);
        });

        mainWindow.rightPanel.getSelectBtn().addActionListener(e -> {
            Player p = (Player) JOptionPane.showInputDialog(mainWindow, "Select a player...", "Player Selection",
                    JOptionPane.PLAIN_MESSAGE,UIManager.getIcon("FileChooser.newFolderIcon"),
                    roster.getRoster().getTable(), roster.getRoster().get(1));
            setPlayerStats(p, mainWindow.rightPanel);
            mainWindow.rightPanel.getStartBtn().setEnabled(true);
        });

        mainWindow.leftPanel.getStartBtn().addActionListener(e -> {
            gameStartFlag1 = true;
            if(gameStartFlag2) {
                playingPhase();
            }
        });

        mainWindow.rightPanel.getStartBtn().addActionListener(e -> {
            gameStartFlag2 = true;
            if(gameStartFlag1) {
                playingPhase();
            }
        });
    }

    //TODO: remove this prolly
//    public void pickingPhase() {
//        mainWindow.hof.setVisible(false);
//        mainWindow.board.setVisible(true);
//        mainWindow.leftPanel.getStartBtn().setEnabled(false);
//        mainWindow.rightPanel.getStartBtn().setEnabled(false);
//        mainWindow.board.disableTTT();
//    }

    public void playingPhase() {
        mainWindow.hof.setVisible(false);
        mainWindow.board.setVisible(true);
        mainWindow.rightPanel.getStartBtn().setEnabled(false);
        mainWindow.rightPanel.getSelectBtn().setEnabled(false);
        mainWindow.leftPanel.getStartBtn().setEnabled(false);
        mainWindow.leftPanel.getSelectBtn().setEnabled(false);
        board.startGame();
        mainWindow.board.enableTTT();
    }


    public void setPlayerStats(Player p, PlayerPanel panel) {
        panel.setName(p.getName());
        panel.setTotal(String.valueOf(p.getHistory().getTotalGames()));
        panel.setWon(String.valueOf(p.getHistory().getWins()));
        panel.setLost(String.valueOf(p.getHistory().getLoses()));
        panel.setTotalScore(String.valueOf(p.getHistory().getScore()));
        //FIXME: delete or finish this:
        //panel.setRecentScore(String.valueOf(p.getHistory().getRecentScore()));

        panel.setToGameState();
    }

    private void endGame() {
        board.endGame();
        mainWindow.topPanel.getDone().setEnabled(true);
        gameStartFlag1 = false;
        gameStartFlag2 = false;
        mainWindow.board.disableTTT();
        board.resetTurn();
    }
}
