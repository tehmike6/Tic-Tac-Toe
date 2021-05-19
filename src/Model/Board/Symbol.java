package Model.Board;

public enum Symbol {
    O,
    X,
    NONE;

    @Override
    public String toString(){
        return this.name().toLowerCase();
    }
}
