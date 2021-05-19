package Main;

import Controller.TTT_control;
import Model.Helpers.*;
import Model.Board.*;
import Model.Players.HumanPlayer;
import Model.Players.Player;
import Model.Statistics.GameRecord;
import View.MainWindow;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws IOException, ForbiddenPlayerNameExc {
        Player p1 = new HumanPlayer("Mike Bastakis");
        Player p2 = new HumanPlayer("Kwstas Chatzis");
        TTT_control test = new TTT_control(p1, p2);
    }
}
