/*
    MineTimer.java
    Create object for timer in Minesweeper, contains all images and time counting properties. 
*/

import java.awt.*;
import javax.swing.*;

public class MineTimer extends Control {
    public int time;
    public ImageIcon[] images;
    public JPanel timerpanel;
    
    MineTimer() {
        // default constructor
    }

    MineTimer(int time) {
        // default properties, initialization
        images = new ImageIcon[3];
        timerpanel = new JPanel();
        /* TEST */ timerpanel.setBackground(Color.CYAN);

        // set default settings and export
        configureImages(ZERO, 0, images, timerpanel);
        changeAnalogOutput(time, images, timerpanel);
        exportTimer();

        // while game is running
        /*if (active) {
            changeTime();
        }*/
    }

    public JPanel exportTimer() {
        return timerpanel;
    }
}
