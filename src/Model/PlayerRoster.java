package Model;

public class PlayerRoster {
    private MyArraylist<Player> roster;

    public void addPlayer(Player p) {
        roster.add(p);
    }

    public MyArraylist<String> findPlayerNames() {
        MyArraylist<String> playerNames = new MyArraylist<>();
        roster.forEach( e -> playerNames.add(e.getName()));
        return  playerNames;
    }

    public Player findPlayer(String name) throws PlayerNotFoundExc{
        for(Player p : roster) {
            if(p.getName().compareTo(name) == 0)
                return p;
        }
        throw new PlayerNotFoundExc("Given name does not exist in the database!");
    }

    public MyArraylist<Player> findHallOfFame(int n) {
        //TODO: finish this!
    }
}
