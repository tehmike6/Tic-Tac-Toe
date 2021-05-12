package Model;

import java.util.Comparator;

public class PlayerComparator implements Comparator<Player> {
    @Override
    public int compare(Player firstPlayer, Player secondPlayer) {
        return Double.compare(firstPlayer.getHistory().getScore(),
                secondPlayer.getHistory().getScore());
    }
}