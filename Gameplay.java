import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Gameplay extends Main {
    
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

    // single player settings
    public Gameplay(JPanel panel, int mode) {
        JButton testinside = new JButton();
        testinside.setVisible(true);
        testinside.setText("HELLO AGAIN! (1)");
        testinside.setPreferredSize(new Dimension(40, 40));
        panel.add(testinside);

        switch(mode) {
            case 0: // easy
                break;
            case 1: // med
                break;
            case 2: // hard
                break;
            case 3: // crazy
                break;
            case 4: // user decides
                break;
        }
    }

    // multiplayer settings 
    public Gameplay(JPanel panel, int mode, int type) {
        JButton testinside = new JButton();
        testinside.setVisible(true);
        testinside.setText("HELLO AGAIN! (2)");
        testinside.setPreferredSize(new Dimension(40, 40));
        panel.add(testinside);
    }
}
