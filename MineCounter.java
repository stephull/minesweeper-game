/* 
    MineCounter.java
    Create object for number of flags/mines present in the game.
*/

import javax.swing.*;
import java.awt.*;

public class MineCounter extends Control {
    
    public int flags;
    public ImageIcon[] images;
    public JPanel countpanel;
    
    MineCounter() {
        // default constructor
    }

    MineCounter(int count) {
        flags = count;
        images = new ImageIcon[3];
        countpanel = new JPanel();

        switch(count) {
            
        }

        configureImages(ZERO, 0, images, countpanel);  
        exportCounter();

        // when game starts
    }

    public void changeCount(int count) {
        int step = 0, temp = count;
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
        for (int i = step; i < images.length; i++) {
            images[i] = new ImageIcon(getClass().getResource(text));
            Image tempimage = images[i].getImage().getScaledInstance(30, 45, Image.SCALE_SMOOTH);
            images[i] = new ImageIcon(tempimage);
            JLabel templabel = new JLabel(images[i]);
            countpanel.add(templabel);
        }
    }*/

    public JPanel exportCounter() {
        return countpanel;
    }
}
