/*
    Control.java

*/

import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Control extends Window {

    // enumerate and define each analog image for the time and counter
    public enum Analog {
        ZERO, ONE, TWO, THREE, FOUR,
        FIVE, SIX, SEVEN, EIGHT, NINE
    };
    public static final String ZERO = "Images/0analog.png";
    public static final String ONE = "Images/1analog.png";
    public static final String TWO = "Images/2analog.png";
    public static final String THREE = "Images/3analog.png";
    public static final String FOUR = "Images/4analog.png";
    public static final String FIVE = "Images/5analog.png";
    public static final String SIX = "Images/6analog.png";
    public static final String SEVEN = "Images/7analog.png";
    public static final String EIGHT = "Images/8analog.png";
    public static final String NINE = "Images/9analog.png";

        // ::: DIFFICULTIES :::
    // easy difficulty -- STANDARD (mode 0)
    public static final int EASY_WH = 9;
    public static final int EASY_MINES = 10;

    // medium difficulty    (mode 1)
    public static final int MED_WH = 9;
    public static final int MED_MINES = 40;

    // hard difficulty  (mode 2)
    public static final int HARD_W = 30;
    public static final int HARD_H = 16;
    public static final int HARD_MINES = 99;

    // crazy difficulty (mode 3)
    public static final int CRAZY_WH = 30;
    public static final int CRAZY_MINES = 255;

    // for optional settings, must be no more than 3600 tiles
    // (mode 4)
    public static final int ABS_WH = 60;
    public static final int ABS_MINES = 999;

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
                mines = EASY_MINES;
                gameWidth = gameHeight = EASY_WH;
                break;
            case 1:
                mines = MED_MINES;
                gameWidth = gameHeight = MED_WH;
                break;
            case 2:
                mines = HARD_MINES;
                gameWidth = HARD_W;
                gameHeight = HARD_H;
                break;
            case 3:
                mines = CRAZY_MINES;
                gameWidth = gameHeight = CRAZY_WH;
                break;
            case 4:
                //Random rand = new Random();
                mines = ABS_MINES;
                gameWidth = gameHeight = ABS_WH;
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

    public void configureImages(String text, int step, ImageIcon[] images, JPanel panel) {
        // for each starting game, TIMER
        for (int i = step; i < images.length; i++) {
            images[i] = new ImageIcon(getClass().getResource(text));
            Image tempimage = images[i].getImage().getScaledInstance(30, 45, Image.SCALE_SMOOTH);
            images[i] = new ImageIcon(tempimage);
            JLabel templabel = new JLabel(images[i]);
            panel.add(templabel);
        }
    }
    public void configureImages(String[] text, int step, ImageIcon[] images, JPanel panel) {
        // ditto, COUNTER (depends on mode)...
        
    }

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
