package Model.Board;

import Model.Players.Player;

public class Board {
    TicTacToe t;
    Player p1, p2;
    int turn;
    long startTime, totalTime;

    public Board(Player p1, Player p2){
        t = new TicTacToe();
        this.p1 = p1;
        this.p2 = p2;
        turn = 0;
    }

    public void startGame() {
        startTime = System.nanoTime();
        //...
    }

    public void endGame() {
        totalTime = System.nanoTime() - startTime;
    }

}
