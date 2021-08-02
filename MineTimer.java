/*
    MineTimer.java
    Create object for timer in Minesweeper, contains all images and time counting properties. 
*/

import java.awt.*;
import javax.swing.*;

public class MineTimer extends ControlPanel {
    protected int time;     // needs access to ControlPanel
    private ImageIcon[] images;
    private JPanel timerpanel;
    
    // getter for time
    protected int getTimer() {
        return time;
    }

    // setter for time
    protected void setTimer(int newTime) {
        this.time = newTime;
    }

    MineTimer() {
        time = 0;

        // default properties, initialization
        images = new ImageIcon[3];
        timerpanel = new JPanel();
        timerpanel.setBackground(Color.DARK_GRAY);

        JLabel l = new JLabel();
        l.setText("Timer:");
        l.setForeground(Color.WHITE);
        timerpanel.add(l);

        // set default settings and export
        configureAnalogImages(ZERO, 0, images, timerpanel);
        //changeAnalogOutput(time, images, timerpanel);
        export();

        // while game is running
        /*if (active) {
            changeTime();
        }*/
    }

    protected JPanel export() {
        return timerpanel;
    }
}
