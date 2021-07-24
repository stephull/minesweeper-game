/* 
    MineCounter.java
    Create object for number of flags/mines present in the game.
*/

import java.awt.*;
import javax.swing.*;

public class MineCounter extends Control {
    public int flags;
    public ImageIcon[] images;
    public JPanel countpanel;
    
    public MineCounter() {
        // default constructor
    }

    public MineCounter(int count) {
        flags = count;
        images = new ImageIcon[3];
        countpanel = new JPanel();
        /* TEST */ countpanel.setBackground(Color.ORANGE);

        String[] sources = new String[3];
        sources[0] = sources[2] = ZERO;
        switch(count) {
            case EASY_MINES:
                sources[1] = ONE;   break;
            case MED_MINES:
                sources[1] = FOUR;  break;
            case HARD_MINES:
                sources[1] = sources[2] = NINE; break;
            case CRAZY_MINES:
                sources[0] = TWO;
                sources[1] = sources[2] = FIVE; break;
            case ABS_MINES:
                sources[0] = sources[1] = sources[2] = NINE;    break;
        }

        configureImages(sources, 0, images, countpanel);
        changeAnalogOutput(count, images, countpanel);
        exportCounter();
    }

    public JPanel exportCounter() {
        return countpanel;
    }

    public void toggleCount() {
        // in-game function to change flags when necessary
    }
}
