/*
    Control.java

*/

import java.awt.*;
import javax.swing.*;

public class Configurations extends Window {

    // ::: DIFFICULTIES :::
    protected final int EASY_WH = 9, EASY_MINES = 10;
    protected final int MED_WH = 9, MED_MINES = 40;
    protected final int HARD_W = 30, HARD_H = 16, HARD_MINES = 99;
    protected final int CRAZY_WH = 30, CRAZY_MINES = 255;
    protected final int ABS_WH = 60, ABS_MINES = 999;
        // ABS_?? for customizable purposes, max limits

    private int gameWidth, gameHeight, mines;
    protected boolean active; // the game is running on a timer?

    Configurations() {
        // default constructor
    }

    Configurations(JPanel panel, GridBagConstraints c) {
        boolean isMulti = false;      // set to single player for default settings, when opening the game
        int mode = 0;            // 0 for easy, 1 for med., 2 for hard, 3 for crazy, 4 for etc.
        int type = (isMulti) ? 1 : 0 ;  // type is 0 if single player; otherwise, pick 1 or 2

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
            ::: create panels for controls and board :::
        */
        createBoard(panel, c);
        createMenu(panel, c);

        // establish new game
        /*Gameplay newgame =*/ new Gameplay(panel, mines, type);
    }

    protected void createBoard(JPanel panel, GridBagConstraints c) {

        // create board of buttons for the game
        JPanel base = new JPanel();
        /*Board board =*/ new Board(base, c, gameHeight, gameWidth);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.CENTER;
        c.weightx = c.weighty = 0.5;
        panel.add(base, c);
    }

    protected void createMenu(JPanel panel, GridBagConstraints c) {
        JPanel base = new JPanel();
        /*ControlPanel cp =*/ new ControlPanel(base, c, mines);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.CENTER;
        c.weightx = c.weighty = 0.5;
        panel.add(base, c);
    }

}
