/*
    Gameplay.java

*/

import java.util.*;
import java.util.concurrent.*;
import javax.swing.*;

public class Gameplay extends Configurations {
    protected static final int timeLeft = 999;

    public Gameplay() {
        // default constructor
    }

    // main gameplay function
    public Gameplay(JPanel panel, int mines, int type) {
        int time = 0;
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
            int x = ThreadLocalRandom.current().nextInt(0, mines);
            int y = ThreadLocalRandom.current().nextInt(0, mines);

            ArrayList<Integer> testArray = new ArrayList<Integer>(Arrays.asList(x, y));
            //System.out.println("BOOO: " + testArray.toString());
            if (coordinatesList.contains(testArray)) {
                x = ThreadLocalRandom.current().nextInt(0, mines);
                y = ThreadLocalRandom.current().nextInt(0, mines);
                //System.out.println("AAAHHH: " + x + " : " + y);
            }

            coordinatesList.add(new ArrayList<Integer>(Arrays.asList(x ,y)));
            temp++;
        }
        System.out.println("TEST: " + coordinatesList);
    }

    public void restartGame() {
        // when user clicks on smiley face

    }

    public void requestMorePlayers() {
        // for multiplayer, get at least 1-3 other players for games

    }
}
