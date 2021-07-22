/*
    MineTimer.java
    Create object for timer in Minesweeper, contains all images and time counting properties. 
*/

import javax.swing.*;
import java.awt.*;

public class MineTimer extends Control {

    public int time;
    public ImageIcon[] images;
    public JPanel timerpanel;
    
    MineTimer() {
        // default properties, initialization
        time = 0;
        images = new ImageIcon[3];
        timerpanel = new JPanel();

        // set default settings and export
        configureImages(ZERO, 0, images, timerpanel);
        exportTimer();

        // while game is running
        /*if (active) {
            changeTime();
        }*/
    }

    public void changeTime(int time) {
        // change images accordingly by its time using 0-9 analog png's 
        // DEFAULT: always set it to 0 0 0 before every game

        // step = where the loop starts to increment
        int step = 0, temp = time;

        if (temp / 100 > 0) {

            temp %= 100;
        } 
        if (temp / 10 > 0) {
            step = 1;

            temp %= 10;
        }
        if (temp > 0) {
            step = 2;

            temp = 0;
        }
    }

    /*public void configureImages(String text, int step) {
        // for each starting game
        for (int i = step; i < images.length; i++) {
            images[i] = new ImageIcon(getClass().getResource(text));
            Image tempimage = images[i].getImage().getScaledInstance(30, 45, Image.SCALE_SMOOTH);
            images[i] = new ImageIcon(tempimage);
            JLabel templabel = new JLabel(images[i]);
            timerpanel.add(templabel);
        }
    }*/

    public JPanel exportTimer() {
        return timerpanel;
    }
}
