/*
    Control.java

*/

import java.util.*;
import java.util.Timer;
import java.awt.*;
import javax.swing.*;

public class Control extends Main {

        // ::: DIFFICULTIES :::
    // easy difficulty -- STANDARD (mode 0)
    public static final int EASY_WIDTH = 9;
    public static final int EASY_HEIGHT = 9;

    // medium difficulty    (mode 1)
    public static final int MED_WIDTH = 16;
    public static final int MED_HEIGHT = 16;

    // hard difficulty  (mode 2)
    public static final int HARD_WIDTH = 16;
    public static final int HARD_HEIGHT = 30;

    // crazy difficulty (mode 3)
    public static final int CRAZY_WIDTH = 30;
    public static final int CRAZY_HEIGHT = 30;

    // for optional settings, must be no more than 3600 tiles
    // (mode 4)
    public static final int ABS_WIDTH = 60;
    public static final int ABS_HEIGHT = 60;

    int gameWidth, gameHeight;

    boolean active; // the game is running on a timer?
    Timer timer;    // for timer
    TimerTask ttask;
    int mines;      // number of mines
    int smile;      // for smiley face button

    public Control() {
        // default constructor
    }

    public Control(JPanel panel) {

        // ::: DEFAULT SETTINGS FOR FIRST GAME :::
        boolean isMulti = false;      
            // set to single player for default settings, when opening the game
        int mode = 0;       
            // 0 for easy, 1 for med., 2 for hard, 3 for crazy, 4 for etc.
        int type = 0;
        if (isMulti) {
            type = 1;
        }
            // type is 0 if single player; otherwise, pick 1 or 2

        JPanel controlpanel = new JPanel();
        controlpanel.setBackground(Color.RED);
                // test case

        active = false;
        timer = new Timer("Timer");

        switch(mode) {
            case 0:
                mines = 10;
                gameWidth = gameHeight = 9;
                break;
            case 1:
                mines = 40;
                gameWidth = gameHeight = 16;
                break;
            case 2:
                mines = 99;
                gameWidth = 30;
                gameHeight = 16;
                break;
            case 3:
                mines = 255;
                gameWidth = gameHeight = 30;
                break;
            case 4:
                Random rand = new Random();
                mines = rand.nextInt(600) + 255;
                    // fix later
                break;
        }

        /*
            ::: switch over from control to main board game panel(s)...
        */

        // create new board for game
        panel.add(controlpanel);
        createBoard(panel);

        // start gameplay
        new Gameplay(panel);
            // QUESTION: is it ok to just pass controlpanel and boardpanel???
    }

    public void createBoard(JPanel panel) {
        // create board of buttons for the game
        JPanel base = new JPanel();
        new Board(base, gameHeight, gameWidth);
        panel.add(base, BorderLayout.CENTER);
    }

    public void createTimer() {
        // create timer
    }

    public void createCounter() {
        // create counter for number of flags
    }

    public void configureSmiley() {
        // ??? create or settings for smiley thing
    }

    public void restartGame() {
        // when user clicks on smiley face
    }

    public void requestMorePlayers() {
        // for multiplayer, get at least 1-3 other players for games
    }
    
}
