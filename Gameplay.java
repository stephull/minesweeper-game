import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Gameplay extends Main {
    
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

    // main gameplay function
    public Gameplay(JPanel panel, int mode, boolean multiplayer, int type) {

        // test button
        JButton testinside = new JButton();
        testinside.setVisible(true);
        testinside.setText("HELLO AGAIN!");
        testinside.setPreferredSize(new Dimension(40, 40));
        panel.add(testinside);

        // panel for smiley face and timers, and generates board
        // based on the respective settings
        new Control(panel, mode);

        // button panel for all buttons
        JPanel boardPanel = new JPanel();
        boardPanel.setBackground(Color.BLUE);
        int gameWidth, gameHeight;
        gameWidth = gameHeight = 9; //default
        switch(mode) {
            case 1:
                gameWidth = gameHeight = 16;
                break;
            case 2:
                gameWidth = 30;
                gameHeight = 16;
                break;
            case 3:
                gameWidth = gameHeight = 30;
                break;
            case 4:
                break;
            default:
                gameWidth = gameHeight = 9;
                break;
        }
        boardPanel.setLayout(new GridLayout(gameWidth, gameHeight));
        panel.add(boardPanel);
    }
}
