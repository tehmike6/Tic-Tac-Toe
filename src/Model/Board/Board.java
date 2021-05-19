package Model.Board;

import Model.Players.Player;

public class Board {
    TicTacToe t;
    Player p1, p2;
    int turn; //1 for p1, 2 for p2
    long startTime, totalTime;

    public Board(Player p1, Player p2){
        t = new TicTacToe();
        this.p1 = p1;
        this.p2 = p2;
        turn = 1;
    }

    public void startGame() {
        t.initializeBoard();
        startTime = System.nanoTime();
    }

    public void endGame() {
        totalTime = System.nanoTime() - startTime;
    }

    public long getTotalTime() {
        return totalTime;
    }

    public Symbol[][] getT() {
        return t.getTTT();
    }

    public TicTacToe getTicTacToe() {
        return t;
    }

    public Player getP1() {
        return p1;
    }

    public Player getP2() {
        return p2;
    }

    public int getTurn() {
        return turn;
    }

    public void nextTurn() {
        if(turn == 2){
            turn = 1;
            return;
        }
        turn = 2;
    }

    public void resetTurn() {
        turn = 1;
    }
}
