/*
    Configurations.java

*/

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Configurations extends Window {

    // ::: DIFFICULTIES :::
    protected final int EASY_WH = 9, EASY_MINES = 10;
    protected final int MED_WH = 9, MED_MINES = 40;
    protected final int HARD_W = 30, HARD_H = 16, HARD_MINES = 99;
    protected final int CRAZY_WH = 30, CRAZY_MINES = 255;
    protected final int ABS_WH = 60, ABS_MINES = 999;
    private int gameWidth, gameHeight, mines;

    protected static ArrayList<ArrayList<Integer>> coordinatesList = new ArrayList<ArrayList<Integer>>();
    protected static boolean active;

    // for smiley face images
    protected final String DEF = "Images/DefaultFace.png";
    protected final String INTER = "Images/InterFace.png";
    protected final String FAIL = "Images/FailFace.png";
    protected final String PASS = "Images/PassFace.png";

    // control panel items
    protected static MineCounter counter;
    protected static MineSmiley smiley;
    protected static MineTimer timer;
    protected static JLabel gamesPlayed, isActive, gamesWon;

    // sample text for panel
    protected static final String IS_ACTIVE_TEXT = "Active game: ";
    protected static final String GAMES_PLAYED_TEXT = "Games played total: ";
    protected static final String GAMES_WON_TEXT = "Games won: ";
    protected static final String HIGHEST_SCORE_TEXT = "Highest score: ";

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

        // adjust based on user's difficulty
        switch(mode) {
            case 0:
                mines = EASY_MINES;
                gameWidth = gameHeight = EASY_WH;   break;
            case 1:
                mines = MED_MINES;
                gameWidth = gameHeight = MED_WH;    break;
            case 2:
                mines = HARD_MINES;
                gameWidth = HARD_W;
                gameHeight = HARD_H;    break;
            case 3:
                mines = CRAZY_MINES;
                gameWidth = gameHeight = CRAZY_WH;  break;
            case 4:
                //Random rand = new Random();
                mines = ABS_MINES;
                gameWidth = gameHeight = ABS_WH;    break;
        }

        /*
            ::: create panels for controls, board, AND initiate Gameplay :::
        */
        Gameplay gameplay = new Gameplay(panel, mines, gameWidth, gameHeight, type);
            // NOTE: gameplay goes first, set up instance before adding opaque objects below
            //      AND gameplay is initialized for run(); see Board.java for example.....
        createControlPanel(panel);
        createBoard(panel);
    }

    protected void createBoard(JPanel panel) {
        JPanel base = new JPanel();
        new Board(base, gameHeight, gameWidth);
        panel.add(base, BorderLayout.CENTER);
    }

    protected void createControlPanel(JPanel panel) {
        JPanel base = new JPanel();
        new ControlPanel(base, mines);
        panel.add(base, BorderLayout.LINE_START);
    }

    public boolean returnActive() {
        return active;
    }
}
