/*
    Configurations.java

*/

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Configurations extends Window implements Runnable {

    protected JPanel base;

    // ::: DIFFICULTIES :::
    protected final int EASY_WH = 9, EASY_MINES = 10;
    protected final int MED_WH = 9, MED_MINES = 40;
    protected final int HARD_W = 30, HARD_H = 16, HARD_MINES = 99;
    protected final int CRAZY_WH = 30, CRAZY_MINES = 255;
    protected final int ABS_WH = 60, ABS_MINES = 999;
    protected static int width, height;
    protected int mines;

    protected static ArrayList<ArrayList<Integer>> coordinatesList = new ArrayList<ArrayList<Integer>>();
    protected boolean active;

    // time contents
    protected Timer timer;
    protected final int MAX_TIME = 999;

    // for smiley face images
    protected final String DEF = "Images/DefaultFace.png";
    protected final String INTER = "Images/InterFace.png";
    protected final String FAIL = "Images/FailFace.png";
    protected final String PASS = "Images/PassFace.png";

    // control panel items
    protected MineCounter mc;
    protected MineSmiley ms;
    protected MineTimer mt;

    // entities for control panel items above
    protected static JLabel gamesPlayed, isActive, gamesWon;
    protected final String IS_ACTIVE_TEXT = "Active game: ";

    Configurations() {
        // default constructor
    }

    Configurations(JPanel panel) {
        /*
            DEFAULT SETTINGS FOR FIRST GAME
        */
        boolean isMulti = false;      // set to single player for default settings, when opening the game
        int mode = 0;            // 0 for easy, 1 for med., 2 for hard, 3 for crazy, 4 for etc.
        int type = (isMulti) ? 1 : 0 ;  // type is 0 if single player; otherwise, pick 1 or 2
        active = false;

        if (mode > 1) {
            toggleWindowSize(true);
        }

        // adjust based on user's difficulty
        switch(mode) {
            case 0:
                mines = EASY_MINES;
                width = height = EASY_WH;   break;
            case 1:
                mines = MED_MINES;
                width = height = MED_WH;    break;
            case 2:
                mines = HARD_MINES;
                width = HARD_W;
                height = HARD_H;    break;
            case 3:
                mines = CRAZY_MINES;
                width = height = CRAZY_WH;  break;
            case 4:
                //Random rand = new Random();
                mines = ABS_MINES;
                width = height = ABS_WH;    break;
        }

        /*
            ::: create panels for controls, board, AND initiate Gameplay :::
        */
        //Gameplay gameplay = new Gameplay(panel, mines, width, height, type);
            // NOTE: gameplay goes first, set up instance before adding opaque objects below
            //      AND gameplay is initialized for run(); see Board.java for example.....
        createControlPanel(panel);
        createBoard(panel);

        if (active) {
            // once game starts, add coordinates
            randomizeCoordinates(mines);
        }
    }

    protected void createBoard(JPanel panel) {
        base = new JPanel();
        new Board(base, mines);
        panel.add(base, BorderLayout.CENTER);
    }

    protected void createControlPanel(JPanel panel) {
        base = new JPanel();
        new ControlPanel(base, mines);
        panel.add(base, BorderLayout.LINE_START);
    }
    
    public boolean isActive() {
        return active;
    }

    public void enableSocketProgram() {

    }

    public void requestMultiplayer() {
        
    }

        // NOTE: all methods here are to be executed in real time while gameplay is initiated
    // METHODS for in-game functions...
    public void randomizeCoordinates(int mines) {
        // look at Board.java >>
        // public void implementRandomMines() for more information

        while (coordinatesList.size() != mines) {
            // range between 0 to set number of width/height
            int x = ThreadLocalRandom.current().nextInt(0, width);
            int y = ThreadLocalRandom.current().nextInt(0, height);

            ArrayList<Integer> testArray = new ArrayList<Integer>(Arrays.asList(x, y));
            if (coordinatesList.contains(testArray)) {
                x = ThreadLocalRandom.current().nextInt(0, width);
                y = ThreadLocalRandom.current().nextInt(0, height);
            }
            coordinatesList.add(new ArrayList<Integer>(Arrays.asList(x ,y)));
        }
        System.out.println("TEST: " + coordinatesList);
    }

    @Override
    public void run() {
        while (active && mt.getTimer() != MAX_TIME) {
            // first, update time on analog display
            // :: MAIN FUNCTIONS ::
            // conclude with timely increment

            int i = 0;
            mt.setTimer(i++);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
