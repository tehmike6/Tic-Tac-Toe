package Model.Players;

import Model.Helpers.ForbiddenPlayerNameExc;

public class HumanPlayer extends Player {


    public HumanPlayer(String name) throws ForbiddenPlayerNameExc {
        super(name);
    }
}
