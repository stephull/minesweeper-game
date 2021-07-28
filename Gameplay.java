/*
    Gameplay.java

*/

import java.util.*;
import java.util.concurrent.*;
import javax.swing.*;

public class Gameplay extends Configurations implements Runnable {
    protected static final int timeLeft = 999;
    protected int timerTime;

    public Gameplay() {
        // default constructor
    }

    // main gameplay function
    public Gameplay(JPanel panel, int mines, int w, int h, int type) {
        timerTime = 0;
        randomizeCoordinates(mines, w, h);

        if (type > 0) {
            requestMorePlayers();
        }

        /*
            NOTE: runnable for system time WHILE game is on... how?
        */
    }       

    public void randomizeCoordinates(int mines, int w, int h) {
        // look at Board.java >>
        // public void implementRandomMines() for more information

        while (coordinatesList.size() != mines) {
            // mines must be in parameters, returns blank list otherwise...
            int x = ThreadLocalRandom.current().nextInt(0, w);
            int y = ThreadLocalRandom.current().nextInt(0, h);

            ArrayList<Integer> testArray = new ArrayList<Integer>(Arrays.asList(x, y));
            if (coordinatesList.contains(testArray)) {
                x = ThreadLocalRandom.current().nextInt(0, w);
                y = ThreadLocalRandom.current().nextInt(0, h);
            }

            coordinatesList.add(new ArrayList<Integer>(Arrays.asList(x ,y)));
        }
        System.out.println("TEST: " + coordinatesList);
    }

    public void requestMorePlayers() {
        // for multiplayer, get at least 1-3 other players for games

    }

    @Override
    public void run() {
        // TODO Auto-generated method stub

        while (active && timerTime != timeLeft) {
            // first, update time on analog display
            // :: MAIN FUNCTIONS ::
            // conclude with timely increment

            System.out.println("SYSTEM TIME: " + timerTime++);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
