package Model;

public class TicTacToe {
    Symbol[][] TTT;

    public TicTacToe() {
        this.TTT = new Symbol[3][3];
        initializeBoard();
    }

    public void initializeBoard(){
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                TTT[i][j] = Symbol.NONE;
            }
        }
    }

    public boolean isBoardFull(){
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if((TTT[i][j]).equals(Symbol.NONE)) return false;
            }
        }
        return true;
    }

    private boolean checkRowsForWin(Symbol s){
        for(int i=0; i<3; i++){
            if(TTT[i][0].equals(s) && TTT[i][1].equals(s) && TTT[i][2].equals(s)) return true;
        }
        return  false;
    }

    private boolean checkColumnsForWin(Symbol s){
        for(int i=0; i<3; i++){
            if(TTT[0][i].equals(s) && TTT[1][i].equals(s) && TTT[2][i].equals(s)) return true;
        }
        return  false;
    }

    private boolean checkDiagonalsForWin(Symbol s){
        if((TTT[0][0].equals(s) || TTT[2][0].equals(s) ) &&
                TTT[1][1].equals(s) &&
                (TTT[2][2].equals(s) || TTT[0][2].equals(s))) return true;

        return false;
    }

    public boolean checkForWin(Symbol s){
        if(checkRowsForWin(s)) return true;
        else if(checkColumnsForWin(s)) return true;
        else if(checkDiagonalsForWin(s)) return true;

        return false;
    }

    public Symbol[][] getTTT(){
        return TTT;
    }

    public void setTTT(int row, int col, Symbol s){
        TTT[row][col] = s;
    }

    public Symbol getTTT(int row, int col){
        return TTT[row][col];
    }
}
