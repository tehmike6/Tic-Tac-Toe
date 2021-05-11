package Model;

public class Board {
    TicTacToe t;
    Player p1, p2;
    int turn;

    public Board(Player p1, Player p2){
        t = new TicTacToe();
        this.p1 = p1;
        this.p2 = p2;
        turn = 0;
    }


}
