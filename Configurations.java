/*
    Configurations.java

*/

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Configurations extends Window implements Runnable {

    // ::: DIFFICULTIES :::
    protected final int EASY_WH = 9, EASY_MINES = 10;
    protected final int MED_WH = 9, MED_MINES = 45;
    protected final int HARD_W = 30, HARD_H = 16, HARD_MINES = 99;
    protected final int CRAZY_WH = 30, CRAZY_MINES = 255;
    protected final int ABS_WH = 60, ABS_MINES = 999;
    protected static int width, height;
    protected int mines;

    protected static ArrayList<ArrayList<Integer>> coordinatesList = new ArrayList<ArrayList<Integer>>();
    public static boolean active = false;
    public static boolean gameOver = false;

    // time contents
    protected Timer timer;
    protected final int MAX_TIME = 999;

    // for smiley face images
    protected final String DEF = "Images/DefaultFace.png";
    protected final String INTER = "Images/InterFace.png";
    protected final String FAIL = "Images/FailFace.png";
    protected final String PASS = "Images/PassFace.png";

    // control panel items
    protected static MineCounter mc;
    protected static MineSmiley ms;
    protected static MineTimer mt;

    // bases for control panel and board
    protected Board board;
    protected ControlPanel cp;
    protected JPanel boardBase;
    protected JPanel cpBase;

    // entities for control panel items above
    protected static JLabel gamesPlayed, gamesWon;

    Configurations() {
        // default constructor
    }

    Configurations(JPanel panel) {
        /*
            DEFAULT ATTRIBUTES FOR FIRST GAME
        */
        boolean isMulti = false;      // set to single player for default settings, when opening the game
        int mode = 0;            // 0 for easy, 1 for med., 2 for hard, 3 for crazy, 4 for etc.
        int type = (isMulti) ? 1 : 0 ;  // type is 0 if single player; otherwise, pick 1 or 2
        active = false;

        // multiplayer games can resize window
        if (type > 0) {
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

        boardBase = new JPanel();
        cpBase = new JPanel();

        mc = new MineCounter(mines);
        ms = new MineSmiley();
        mt = new MineTimer();
        
        createControlPanel(panel);
        createBoard(panel);

        /*if (active) {
            // once game starts, add coordinates
            randomizeCoordinates(mines);
        }*/
    }

    protected void createBoard(JPanel panel) {
        new Board(boardBase, mines);
        panel.add(boardBase, BorderLayout.CENTER);
    }

    protected void createControlPanel(JPanel panel) {
        new ControlPanel(cpBase, mines);
        panel.add(cpBase, BorderLayout.LINE_START);
    }

    // 

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
            System.out.println(i);
        }
    }
}
