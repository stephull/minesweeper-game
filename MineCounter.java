/* 
    MineCounter.java
    Create object for number of flags/mines present in the game.
*/

import java.awt.*;
import javax.swing.*;

public class MineCounter extends ControlPanel {
    protected int flags;
    private ImageIcon[] images;
    private JPanel countpanel;

    // getter for flags
    protected int getCounter() {
        return flags;
    }

    // setter for flag count
    protected void setCounter(int newFlags) {
        this.flags = newFlags;
    }
    
    MineCounter() {
        // default constructor
    }

    MineCounter(int count) {
        flags = count;
        images = new ImageIcon[3];
        countpanel = new JPanel();
        countpanel.setBackground(Color.DARK_GRAY);

        JLabel l = new JLabel();
        l.setText("Flags:");
        l.setForeground(Color.WHITE);
        countpanel.add(l);

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

        configureAnalogImages(sources, 0, images, countpanel);
        //changeAnalogOutput(count, images, countpanel); // SAVE for another time
        export();
    }

    protected JPanel export() {
        return countpanel;
    }
}
