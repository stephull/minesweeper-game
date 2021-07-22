/*
    Control.java

*/

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
    public static final int EASY_WH = 9, EASY_MINES = 10;
    public static final int MED_WH = 9, MED_MINES = 40;
    public static final int HARD_W = 30, HARD_H = 16, HARD_MINES = 99;
    public static final int CRAZY_WH = 30, CRAZY_MINES = 255;
    public static final int ABS_WH = 60, ABS_MINES = 999;
        // ABS_?? for customizable purposes, max limits

    int gameWidth, gameHeight;
    boolean active; // the game is running on a timer?
    int time;

    // other control panel properties
    int mines;      // number of mines
    int smile;      // for smiley face button

    public Control() {
        // default constructor
    }

    public Control(JPanel panel, GridBagConstraints c) {
        boolean isMulti = false;      // set to single player for default settings, when opening the game
        int mode = 0;            // 0 for easy, 1 for med., 2 for hard, 3 for crazy, 4 for etc.
        int type = (isMulti) ? 1 : 0 ;  // type is 0 if single player; otherwise, pick 1 or 2

        // components for the control panel in game window
        JPanel controlpanel = new JPanel();
        active = false;
        time = 0;   // incremenets as Minesweeper is active

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

        // configure items for control panel above game board
        createCounter(controlpanel, mines);
        configureSmiley(controlpanel);
        createTimer(controlpanel);
        panel.add(controlpanel);

        /*
            ::: switch over from control to main board game panel(s)...
        */
        createBoard(panel, c);
        new Gameplay(panel);
    }

    public void createBoard(JPanel panel, GridBagConstraints c) {

        // create board of buttons for the game
        JPanel base = new JPanel();
        Board board = new Board(base, c, gameHeight, gameWidth);

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
            images[i] = new ImageIcon(images[i].getImage().getScaledInstance(30, 45, Image.SCALE_SMOOTH));
                // new ImageIcon( ** property of Image object put back into ImageIcon ** )
            panel.add(new JLabel(images[i]));
        }
    }   public void configureImages(String[] text, int step, ImageIcon[] images, JPanel panel) {
        // ditto, COUNTER (depends on mode)...
        for (int i = step; i < images.length; i++) {
            images[i] = new ImageIcon(getClass().getResource(text[i]));
            images[i] = new ImageIcon(images[i].getImage().getScaledInstance(30, 45, Image.SCALE_SMOOTH));
            panel.add(new JLabel(images[i]));
        }
    }

    public String getAnalog(int input) {
        switch(input) {
            case 1: return ONE;
            case 2: return TWO;
            case 3: return THREE;
            case 4: return FOUR;
            case 5: return FIVE;
            case 6: return SIX;
            case 7: return SEVEN;
            case 8: return EIGHT;
            case 9: return NINE;
            default: return ZERO;
        }
    }

    public void changeAnalogOutput(int numericInput, ImageIcon[] images, JPanel panel) {
        // change images accordingly by its time using 0-9 analog png's 

        // FOR TIMER: always set it to 0 0 0 before every game
        // FOR COUNTER: arbitrary numbers, set according to mine count
        int temp = numericInput;
        if (temp / 100 > 0) {
            configureImages(getAnalog(temp / 100), 0, images, panel);
            temp %= 100;
        } 
        if (temp / 10 > 0) {
            configureImages(getAnalog(temp / 10), 1, images, panel);
            temp %= 10;
        }
        if (temp > 0) {
            configureImages(getAnalog(temp), 2, images, panel);
            temp = 0;
        }
    }

    // creation of control panel items
    public void createTimer(JPanel panel) {
        // create timer
        MineTimer timer = new MineTimer(time);
        panel.add(timer.exportTimer());
    }

    public void configureSmiley(JPanel panel) {
        // ??? create or settings for smiley thing
        MineSmiley smiley = new MineSmiley();
        panel.add(smiley.exportSmiley());
    }

    public void createCounter(JPanel panel, int count) {
        // create counter for number of flags
        MineCounter counter = new MineCounter(count);
        panel.add(counter.exportCounter());
    }

}
