/*
    Control.java

*/

import java.util.*;
import java.util.Timer;
import java.awt.*;
import javax.swing.*;

public class Control extends Window {

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

    // other control panel properties
    int mines;      // number of mines
    int smile;      // for smiley face button

    public Control() {
        // default constructor
    }

    public Control(JPanel panel, GridBagConstraints c) {

        // ::: DEFAULT SETTINGS FOR FIRST GAME :::
        boolean isMulti = false;      // set to single player for default settings, when opening the game
        int mode = 0;            // 0 for easy, 1 for med., 2 for hard, 3 for crazy, 4 for etc.
        int type = (isMulti) ? 1 : 0 ;  // type is 0 if single player; otherwise, pick 1 or 2

        // components for the control panel in game window
        JPanel controlpanel = new JPanel();
        active = false;

        // adjust based on user's difficulty
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

        // configure items for control panel above game board
        createTimer(controlpanel);
        createCounter(controlpanel, mines);
        configureSmiley(controlpanel);
        panel.add(controlpanel);

        /*
            ::: switch over from control to main board game panel(s)...
        */
        // create new board for game
        createBoard(panel, c);

        // start gameplay
        new Gameplay(panel);
            // QUESTION: is it ok to just pass controlpanel and boardpanel???
    }

    public void createBoard(JPanel panel, GridBagConstraints c) {

        // create board of buttons for the game
        JPanel base = new JPanel();
        new Board(base, c, gameHeight, gameWidth);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.CENTER;
        c.weightx = c.weighty = 0.5;
        panel.add(base, c);
    }

    /*
        Objects for Control Panel
        Each object returns either a JPanel or JButton
    */
    public void createTimer(JPanel panel) {
        // create timer
        MineTimer timer = new MineTimer();
        panel.add(timer.exportTimer());
    }

    public void createCounter(JPanel panel, int count) {
        // create counter for number of flags
        MineCounter counter = new MineCounter(count);
        panel.add(counter.exportCounter());
    }

    public void configureSmiley(JPanel panel) {
        // ??? create or settings for smiley thing
        MineSmiley smiley = new MineSmiley();
        panel.add(smiley.exportSmiley());
    }
}
