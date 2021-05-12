package Model;

import java.util.Arrays;

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
        int totalPlayers = roster.getSize();
        Player[] players = new Player[totalPlayers];
        for(int i = 0; i < totalPlayers; i++) {
            players[i] = roster.get(i);
        }
        Arrays.sort(players, new PlayerComparator());
        MyArraylist<Player> topPlayers = new MyArraylist<>();
        /*TODO: May need to be reversed, test if it returns the worst instead
        of the best players! */
        for(int i = 0; i < n; i++){
            topPlayers.add(players[i]);
        }
        return topPlayers;
    }
}
