/*
    Gameplay.java

*/

import java.util.*;
import java.util.concurrent.*;
import javax.swing.*;

public class Gameplay extends Configurations {

    public boolean active;
    public HashSet<ArrayList<Integer>> coordinates;

    public final int timeLeft = 999;

    public Gameplay() {
        // default constructor
    }

    // main gameplay function
    public Gameplay(JPanel panel, int mines, int type) {
        int time = 0;
        active = false;
        coordinates = new HashSet<ArrayList<Integer>>();
        randomizeCoordinates(mines);

        if (type > 0) {
            requestMorePlayers();
        }

        /* 
            :: for in-game function(s) ::
        */
        while (time != timeLeft) {
            // first, update time on analog display
            // :: MAIN FUNCTIONS ::
            // conclude with timely increment
            time++;
        }
    }       

    public void randomizeCoordinates(int mines) {
        // look at Board.java >>
        // public void implementRandomMines() for more information
        int temp = 0;
        while (temp != mines) {
            // mines must be in parameters, returns blank list otherwise...
            int x = ThreadLocalRandom.current().nextInt(1, 10);
            int y = ThreadLocalRandom.current().nextInt(1, 10);
            coordinates.add(new ArrayList<Integer>(Arrays.asList(x, y)));
            temp++;
        }
        System.out.println("TEST: " + coordinates);
    }

    public void restartGame() {
        // when user clicks on smiley face

    }

    public void requestMorePlayers() {
        // for multiplayer, get at least 1-3 other players for games

    }
}
