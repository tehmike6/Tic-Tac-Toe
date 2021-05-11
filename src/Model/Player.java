package Model;

public abstract class Player {
    private String name;
    private History history;

    public Player(String name) {
        this.name = name;
        this.history = new History();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public History getHistory() {
        return history;
    }

    public void setHistory(History history) {
        this.history = history;
    }
}